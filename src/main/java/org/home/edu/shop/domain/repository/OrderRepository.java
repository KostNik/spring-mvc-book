package org.home.edu.shop.domain.repository;

import org.home.edu.shop.domain.Order;

public interface OrderRepository {
    long saveOrder(Order order);

}
