package org.home.edu.shop.domain.repository.impl;

import org.home.edu.shop.domain.Cart;
import org.home.edu.shop.domain.CartItem;
import org.home.edu.shop.service.ProductService;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by SweetHome on 25.06.2017.
 */
public class CartMapper implements RowMapper<Cart> {

    private CartItemMapper cartItemMapper;
    private NamedParameterJdbcTemplate jdbcTempleate;

    public CartMapper(ProductService productService, NamedParameterJdbcTemplate jdbcTempleate) {
        this.cartItemMapper = new CartItemMapper(productService);
        this.jdbcTempleate = jdbcTempleate;
    }

    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        String id = rs.getString("ID");
        String SQL = String.format("SELECT * FROM CART_ITEM WHERE CARD_ID='%s'", id);
        Cart cart = new Cart(id);
        List<CartItem> items = jdbcTempleate.query(SQL, cartItemMapper);
        cart.setCartItems(items);
        return cart;
    }
}
