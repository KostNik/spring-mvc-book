package org.home.edu.shop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by SweetHome on 11.06.2017.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No products found under this category")
public class NoProductsFoundUnderCategoryException extends RuntimeException {

    public NoProductsFoundUnderCategoryException() {
        super();
    }
}
