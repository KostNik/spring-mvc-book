package org.home.edu.shop.validator;

import org.home.edu.shop.exceptions.ProductNotFoundException;
import org.home.edu.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by SweetHome on 14.06.2017.
 */
@Component
public class ProductIdValidator implements ConstraintValidator<ProductId, String> {

    private final ProductService productService;

    @Autowired
    public ProductIdValidator(ProductService productService) {
        this.productService = productService;
    }


    public void initialize(ProductId constraint) {
    }


    public boolean isValid(String obj, ConstraintValidatorContext context) {
        try {
            productService.getProductById(obj);
        } catch (ProductNotFoundException e) {
            return true;
        }
        return false;
    }
}
