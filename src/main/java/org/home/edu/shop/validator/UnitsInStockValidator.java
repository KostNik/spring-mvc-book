package org.home.edu.shop.validator;

import org.home.edu.shop.domain.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

/**
 * Created by SweetHome on 15.06.2017.
 */
public class UnitsInStockValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        BigDecimal price = product.getUnitPrice();
        if (price != null && new BigDecimal(1000).compareTo(price) <= 0 && product.getUnitsInStock() > 99) {
            errors.rejectValue("unitsInStock", "org.home.validator.UnitsInStockValidator.message");
        }
    }
}
