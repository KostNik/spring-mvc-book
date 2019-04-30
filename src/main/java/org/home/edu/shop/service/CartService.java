package org.home.edu.shop.service;

import org.home.edu.shop.domain.Cart;
import org.home.edu.shop.domain.CartDto;

/**
 * Created by SweetHome on 26.06.2017.
 */
public interface CartService {

    void create(CartDto cartDto);

    Cart read(String cartId);

    void update(String cartId, CartDto cartDto);

    void delete(String id);

    void addItem(String cartId, String productId);

    void removeItem(String cartId, String productId);

    Cart validate(String cartId);

    void clearCart(String cartId);


}
