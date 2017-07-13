package com.neng.service;

import com.neng.pojo.Need;
import com.neng.pojo.Order;
import com.neng.pojo.OrderItems;
import com.neng.pojo.User;
import com.neng.pojo.config.Api;
import com.neng.repository.OrderItemsRepository;
import com.neng.repository.OrderRepository;
import com.neng.service.inner.OrderService;
import com.neng.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by nengneng on 2017/7/13.
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private Order order;

    private List<Order> orders;

    private OrderRepository orderRepository;
    private OrderItemsRepository orderItemsRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderItemsRepository orderItemsRepository) {
        this.orderRepository = orderRepository;
        this.orderItemsRepository = orderItemsRepository;
    }

    /**
     * 获取所有的订单
     *
     * @return
     */
    @Override
    public ResponseEntity<?> getOrders(User user) {
        orders = orderRepository.findByUser(user);
        Result<List<Order>> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(orders);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 保存订单
     *
     * @param order
     * @return
     */
    @Override
    public ResponseEntity<?> saveAndFlushOrder(User user,Order order, Set<OrderItems> orderItems) {
        saveOrderItems(user,order, orderItems);
        Result<Order> result = new Result<>();
        result.api(Api.SUCCESS);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 获取单个订单
     * @param orderId
     * @return
     */
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

    @Transactional
    private void saveOrderItems(User user,Order order, Set<OrderItems> orderItems) {

        order.setOrderItems(orderItems);
        order.setUser(user);
        Order o = orderRepository.save(order);
        for (OrderItems orderI: orderItems
             ) {
            orderI.setOrder(o);
            orderI.setCreateTime(new Date());
            orderI.setTradeTime(new Date());
            orderItemsRepository.saveAndFlush(orderI);

        }

    }

}
