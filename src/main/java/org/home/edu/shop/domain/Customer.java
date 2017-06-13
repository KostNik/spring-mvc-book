package org.home.edu.shop.domain;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by SweetHome on 03.06.2017.
 */
@Data
public class Customer implements Serializable {

    private Long customerId;
    private String name;
    private String address;
    private Long noOfOrdersMade;

}
