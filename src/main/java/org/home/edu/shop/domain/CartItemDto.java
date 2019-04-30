package org.home.edu.shop.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by SweetHome on 25.06.2017.
 */
@Data
public class CartItemDto implements Serializable {

    private static final long serialVersionUID = 2403439725998959163L;
    private String id;
    private String productId;
    private int quantity;

}
