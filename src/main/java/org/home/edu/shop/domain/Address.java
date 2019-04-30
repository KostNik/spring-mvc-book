package org.home.edu.shop.domain;

import lombok.Data;

@Data
public class Address {

    private static final long serialVersionUID = -530086768384258062L;
    private Long   id;
    private String doorNo;
    private String streetName;
    private String areaName;
    private String state;
    private String country;
    private String zipCode;

}
