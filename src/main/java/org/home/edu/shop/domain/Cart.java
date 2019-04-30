package org.home.edu.shop.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

/**
 * Created by SweetHome on 25.06.2017.
 */
@Data
@NoArgsConstructor
public class Cart implements Serializable {

    private static final long serialVersionUID = 8269309749469937485L;
    private String id;
    private List<CartItem> cartItems;
    private BigDecimal grandTotal;

    public Cart(String id) {
        this.id = id;
    }

    public BigDecimal getGrandTotal() {
        this.updateGrandTotal();
        return grandTotal;
    }

    private void updateGrandTotal() {
        Function<CartItem, BigDecimal> totalMapper = CartItem::getTotalPrice;
        BigDecimal grandTotal = cartItems.stream()
                .map(totalMapper)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        setGrandTotal(grandTotal);
    }

    public CartItem getItemByProductId(String productId) {
        return cartItems.stream().filter(cartItem ->
                cartItem.getProduct().getProductId().equals(productId))
                .findAny()
                .orElse(null);
    }


}
