package org.home.edu.shop.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SweetHome on 25.06.2017.
 */
@Data
public class CartDto implements Serializable {

    private String id;
    private List<CartItemDto> cartItems;

    public CartDto(String id) {
        this.id = id;
    }

    public void addCartItem(CartItemDto cartItemDto) {
        cartItems.add(cartItemDto);
    }
}
