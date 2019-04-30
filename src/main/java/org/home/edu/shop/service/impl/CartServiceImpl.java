package org.home.edu.shop.service.impl;

import org.home.edu.shop.domain.Cart;
import org.home.edu.shop.domain.CartDto;
import org.home.edu.shop.domain.repository.CartRepository;
import org.home.edu.shop.exceptions.InvalidCartException;
import org.home.edu.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by SweetHome on 26.06.2017.
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;


    @Override
    public void create(CartDto cartDto) {
        cartRepository.create(cartDto);
    }

    @Override
    public Cart read(String cartId) {
        return cartRepository.read(cartId);
    }

    @Override
    public void update(String cartId, CartDto cartDto) {
        cartRepository.update(cartId, cartDto);
    }

    @Override
    public void delete(String id) {
        cartRepository.delete(id);
    }

    @Override
    public void addItem(String cartId, String productId) {
        cartRepository.addItem(cartId, productId);
    }

    @Override
    public void removeItem(String cartId, String productId) {
        cartRepository.removeItem(cartId, productId);
    }

    @Override
    public Cart validate(String cartId) {
        Cart cart = cartRepository.read(cartId);
        if (cart == null || cart.getCartItems().size() == 0) {
            throw new InvalidCartException(cartId);
        }
        return cart;
    }

    @Override
    public void clearCart(String cartId) {
        cartRepository.clearCart(cartId);
    }

}
