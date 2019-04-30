package org.home.edu.shop.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SweetHome on 25.06.2017.
 */
@Data
@NoArgsConstructor
public class CartDto implements Serializable {


    private static final long serialVersionUID = 4792003102830304452L;
    private String id;
    private List<CartItemDto> cartItems;

    public CartDto(String id) {
        this.id = id;
    }

    public void addCartItem(CartItemDto cartItemDto) {
        cartItems.add(cartItemDto);
    }
}
