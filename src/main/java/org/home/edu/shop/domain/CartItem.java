package org.home.edu.shop.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by SweetHome on 25.06.2017.
 */
@Data
public class CartItem implements Serializable {

    private String id;
    private Product product;
    private int quantity;
    private BigDecimal totalPrice;

    public CartItem(String id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.updateTotalPrice();
    }

    public BigDecimal getTotalPrice() {
        this.updateTotalPrice();
        return totalPrice;
    }

    public void updateTotalPrice() {
        totalPrice = product.getUnitPrice().multiply(new BigDecimal(quantity));
    }


}
