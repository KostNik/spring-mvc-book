package org.home.edu.shop.domain.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.home.edu.shop.domain.*;
import org.home.edu.shop.domain.repository.CartRepository;
import org.home.edu.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SweetHome on 25.06.2017.
 */
@Slf4j
@Repository
public class InMemoryCartRepository implements CartRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private ProductService             productService;

    @Override
    public void create(CartDto cartDto) {
        String INSERT_CART_SQL = "INSERT INTO CART(ID) VALUES (:id)";
        Map<String, Object> params = new HashMap<>();
        params.put("id", cartDto.getId());
        jdbcTemplate.update(INSERT_CART_SQL, params);

        cartDto.getCartItems().forEach(cartItemDto -> {
            Product productById = productService.getProductById(cartItemDto.getProductId());
            String INSERT_CART_ITEM_SQL =
                    "INSERT INTO CART_ITEM (ID, PRODUCT_ID, CART_ID, QUANTITY)" +
                            "VALUES (:id, :product_id, :cart_id, :quantity)";
            Map<String, Object> cartItemsParams = new HashMap<>();
            cartItemsParams.put("id", cartItemDto.getId());
            cartItemsParams.put("product_id", productById.getProductId());
            cartItemsParams.put("cart_id", cartDto.getId());
            cartItemsParams.put("quantity", cartItemDto.getQuantity());
            jdbcTemplate.update(INSERT_CART_ITEM_SQL, cartItemsParams);
        });
    }

    @Override
    public Cart read(String id) {
        String SQL = "SELECT * FROM CART WHERE ID = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        CartMapper cartMapper = new CartMapper(productService, jdbcTemplate);
        return jdbcTemplate.queryForObject(SQL, params, cartMapper);
    }

    @Override
    public void update(String id, CartDto cartDto) {
        List<CartItemDto> cartItemDtos = cartDto.getCartItems();
        String SQL = "UPDATE CART_ITEM SET QUANTITY = :quantity, PRODUCT_ID = :product_id WHERE ID = :id AND CART_ID =:cart_id";
        cartItemDtos.forEach(cartItemDto -> {
            Map<String, Object> params = new HashMap<>();
            params.put("id", cartItemDto.getId());
            params.put("product_id", cartItemDto.getProductId());
            params.put("quantity", cartItemDto.getQuantity());
            params.put("cart_id", id);
            jdbcTemplate.update(SQL, params);
        });
    }

    @Override
    public void delete(String id) {
        String SQL_DELETE_CART_ITEM = "DELETE FROM CART_ITEM WHERE CART_ID = :id";
        String SQL_DELETE_CART = "DELETE FROM CART WHERE ID = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.update(SQL_DELETE_CART_ITEM, params);
        jdbcTemplate.update(SQL_DELETE_CART, params);
    }

    @Override
    public void addItem(String cartId, String productId) {
        String SQL;
        Cart cart = read(cartId);
        if (cart == null) {
            CartItemDto newCartItemDto = new CartItemDto();
            newCartItemDto.setId(cartId + productId);
            newCartItemDto.setProductId(productId);
            newCartItemDto.setQuantity(1);
            CartDto newCartDto = new CartDto(cartId);
            newCartDto.addCartItem(newCartItemDto);
            create(newCartDto);
            return;
        }
        Map<String, Object> cartItemsParams = new HashMap<>();
        if (cart.getItemByProductId(productId) == null) {
            SQL = "INSERT INTO CART_ITEM (ID, PRODUCT_ID, CART_ID, QUANTITY)VALUES(:id, :productId, :cartId, :quantity)";
            cartItemsParams.put("id", cartId + productId);
            cartItemsParams.put("quantity", 1);
        } else {
            SQL = "UPDATE CART_ITEM SET QUANTITY =:quantity WHERE CART_ID = :cartId AND PRODUCT_ID =:productId ";
            CartItem existingItem = cart.getItemByProductId(productId);
            cartItemsParams.put("id", existingItem.getId());
            cartItemsParams.put("quantity", existingItem.getQuantity() + 1);
        }
        cartItemsParams.put("productId", productId);
        cartItemsParams.put("cartId", cartId);
        jdbcTemplate.update(SQL, cartItemsParams);
    }

    @Override
    public void removeItem(String cartId, String productId) {
        String DELETE_CART_ITEM = "DELETE FROM CART_ITEM WHERE PRODUCT_ID = :product_id AND CART_ID = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", cartId);
        params.put("product_id", productId);
        jdbcTemplate.update(DELETE_CART_ITEM, params);
    }

    @Override
    public void clearCart(String cartId) {
        String SQL_DELETE_CART_ITEM = "DELETE FROM CART_ITEM WHERE CART_ID = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", cartId);
        jdbcTemplate.update(SQL_DELETE_CART_ITEM, params);
    }


}
