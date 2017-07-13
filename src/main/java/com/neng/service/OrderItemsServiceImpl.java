package com.neng.service;

import com.neng.pojo.Need;
import com.neng.pojo.Order;
import com.neng.pojo.OrderItems;
import com.neng.pojo.config.Api;
import com.neng.repository.OrderItemsRepository;
import com.neng.service.inner.OrderItemsService;
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
public class OrderItemsServiceImpl implements OrderItemsService {
    private OrderItems orderItems;

    private List<OrderItems> orderItemss;

    private OrderItemsRepository orderItemsRepository;

    @Autowired
    public OrderItemsServiceImpl(OrderItemsRepository orderItemsRepository) {
        this.orderItemsRepository = orderItemsRepository;
    }

    @Override
    public ResponseEntity<?> getOrderItems() {
        orderItemss = orderItemsRepository.findAll();
        Result<List<OrderItems>> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(orderItemss);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> save(OrderItems orderItems) {
        orderItemsRepository.save(orderItems);
        Result<OrderItems> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setCode(1);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> saveAndFlush(OrderItems orderItems) {
        orderItemsRepository.saveAndFlush(orderItems);
        Result<OrderItems> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setCode(1);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getOne(long orderItemsId) {
        orderItems = orderItemsRepository.getOne(orderItemsId);
        Result<OrderItems> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(orderItems);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getByNeed(Need need) {
        orderItemss = orderItemsRepository.getByNeed(need);
        Result<List<OrderItems>> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(orderItemss);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getByOrder(Order order) {
        orderItemss = orderItemsRepository.getByOrder(order);
        Result<List<OrderItems>> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(orderItemss);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
