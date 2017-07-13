package com.neng.service;

import com.neng.pojo.Need;
import com.neng.pojo.Order;
import com.neng.pojo.config.Api;
import com.neng.repository.OrderRepository;
import com.neng.service.inner.OrderService;
import com.neng.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nengneng on 2017/7/13.
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    private Order order;

    private List<Order> orders;

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public ResponseEntity<?> getOrders() {
        orders = orderRepository.findAll();
        Result<List<Order>> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(orders);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> save(Order order) {
        orderRepository.save(order);
        Result<Order> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setCode(1);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> saveAndFlushOrder(Order order) {
        orderRepository.saveAndFlush(order);
        Result<Order> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setCode(1);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getOne(long orderId) {
        order = new Order();
        order = orderRepository.getOne(orderId);
        Result<Order> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(order);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getByNeed(Need need) {
        order = new Order();
        order = orderRepository.getByNeed(need);
        Result<Order> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(order);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getByNumber(String number) {
        order = new Order();
        order = orderRepository.getByNumber(number);
        Result<Order> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(order);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
