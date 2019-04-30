package org.home.edu.shop.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by SweetHome on 03.06.2017.
 */
@Data
public class Customer implements Serializable {

    private static final long serialVersionUID = 2284040482222162898L;

    private Long    customerId;
    private String  name;
    private String  phoneNumber;
    private Address billingAddress;

    public Customer() {
        super();
        this.billingAddress = new Address();
    }

    public Customer(Long customerId, String name) {
        this();
        this.customerId = customerId;
        this.name = name;
    }


}
