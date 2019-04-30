package org.home.edu.shop.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ShippingDetail {

    private static final long serialVersionUID = 6350930334140807514L;
    private Long    id;
    private String  name;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date    shippingDate;
    private Address shippingAddress;


}
