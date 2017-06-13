package org.home.edu.shop.domain.repository;

import org.home.edu.shop.domain.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by SweetHome on 03.06.2017.
 */
public interface ProductRepository {
    List<Product> getAllProducts();

    void updateStock(String productId, long noOfUnits);

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    List<Product> getProductsByFilterCategoryAndMaxPrice(String category, Long maxPrice);

    List<Product> getProductsByFilter(Map<String, List<String>> priceRange, String category, String brand);

    Product getProductById(String productId);

    void addProduct(Product product);
}
