package org.home.edu.shop.service.impl;

import org.home.edu.shop.domain.Product;
import org.home.edu.shop.domain.repository.ProductRepository;
import org.home.edu.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by SweetHome on 03.06.2017.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void updateAllStock() {
        List<Product> products = getAllProducts();
        products.stream()
                .filter(product -> product.getUnitsInStock() < 500)
                .forEach(product -> productRepository.updateStock(product.getProductId()
                        , product.getUnitsInStock() + 1000));
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }

    @Override
    public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsByFilter(filterParams);
    }

    @Override
    public List<Product> getProductsByFilterCategoryAndMaxPrice(String category, Long maxPrice) {
        return productRepository.getProductsByFilterCategoryAndMaxPrice(category, maxPrice);
    }

    @Override
    public List<Product> getProductsByFilter(Map<String, List<String>> priceRange, String category, String brand) {
        return productRepository.getProductsByFilter(priceRange, category, brand);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public Product getProductById(String productId) {
        return productRepository.getProductById(productId);
    }


    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}
