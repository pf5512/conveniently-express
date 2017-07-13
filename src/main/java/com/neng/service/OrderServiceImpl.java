package com.neng.service;

import com.neng.pojo.Order;
import com.neng.repository.OrderRepository;
import com.neng.service.inner.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by nengneng on 2017/7/13.
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public ResponseEntity<?> getOrders() {
        return null;
    }

    @Override
    public ResponseEntity<?> save(Order order) {
        return null;
    }
}
