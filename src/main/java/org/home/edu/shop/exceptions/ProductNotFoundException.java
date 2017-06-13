package org.home.edu.shop.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by SweetHome on 11.06.2017.
 */
@Getter
@AllArgsConstructor
public class ProductNotFoundException extends RuntimeException {

    private String productId;

}
