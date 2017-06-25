package org.home.edu.shop.domain.repository.impl;

import org.home.edu.shop.domain.CartItem;
import org.home.edu.shop.service.ProductService;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SweetHome on 25.06.2017.
 */
public class CartItemMapper implements RowMapper<CartItem> {

    private ProductService productService;

    public CartItemMapper(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        CartItem cartItem = new CartItem(rs.getString("ID"));
        cartItem.setQuantity(rs.getInt("QUANTITY"));
        cartItem.setProduct(productService.getProductById(rs.getString("PRODUCT_ID")));
        return cartItem;
    }
}
