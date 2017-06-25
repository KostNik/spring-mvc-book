package org.home.edu.shop.domain.repository;

import org.home.edu.shop.domain.Cart;
import org.home.edu.shop.domain.CartDto;

/**
 * Created by SweetHome on 25.06.2017.
 */
public interface CartRepository {

    void create(CartDto cartDto);

    Cart read(String id);

    void update(String id, CartDto cartDto);

    void delete(String id);

    void addItem(String cartId, String productId);

    void removeItem(String cartId, String productId);
}
