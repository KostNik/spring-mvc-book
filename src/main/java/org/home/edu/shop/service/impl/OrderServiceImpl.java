package org.home.edu.shop.service.impl;

import org.home.edu.shop.domain.Order;
import org.home.edu.shop.domain.repository.OrderRepository;
import org.home.edu.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Long saveOrder(Order order) {
        return orderRepository.saveOrder(order);
    }

}
