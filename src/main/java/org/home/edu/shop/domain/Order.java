package org.home.edu.shop.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {

    private static final long serialVersionUID = -3560539622417210365L;

    private Long           orderId;
    private Cart           cart;
    private Customer       customer;
    private ShippingDetail shippingDetail;

    public Order() {
        this.customer = new Customer();
        this.shippingDetail = new ShippingDetail();
    }


}
