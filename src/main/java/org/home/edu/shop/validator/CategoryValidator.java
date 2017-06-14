package org.home.edu.shop.validator;

import org.home.edu.shop.domain.ProductCategory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by SweetHome on 14.06.2017.
 */
public class CategoryValidator implements ConstraintValidator<Category, String> {


    public void initialize(Category constraint) {
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {
        return ProductCategory.contains(obj);
    }
}
