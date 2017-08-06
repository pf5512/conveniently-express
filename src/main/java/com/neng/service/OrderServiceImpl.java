package com.neng.service;

import com.neng.pojo.Need;
import com.neng.pojo.Order;
import com.neng.pojo.OrderItems;
import com.neng.pojo.User;
import com.neng.pojo.config.Api;
import com.neng.repository.OrderItemsRepository;
import com.neng.repository.OrderRepository;
import com.neng.repository.UserRepository;
import com.neng.service.inner.OrderService;
import com.neng.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@Transactional
public class OrderServiceImpl implements OrderService {

    private Order order;

    private List<Order> orders;

    private OrderRepository orderRepository;
    private OrderItemsRepository orderItemsRepository;
    private UserRepository userRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderItemsRepository orderItemsRepository,
                            UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.orderItemsRepository = orderItemsRepository;
        this.userRepository = userRepository;
    }

    /**
     * 获取所有的订单
     *
     * @return
     */
    @Override
    public ResponseEntity<?> getOrdersByUser(User user) {
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
    public ResponseEntity<?> saveAndFlushOrder(Order order, User user, Need need) {
        order.setUser(user);
        order.setNeed(need);
        Order orderDate = orderRepository.save(order);
//        saveOrderItems(userId, order, orderItems);
        Result<Order> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(orderDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 获取单个订单
     *
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

        if (order == null) {
            result.api(Api.SERVRE_ERROR);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        result.api(Api.SUCCESS);
        result.setData(order);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(Order order) {
        orderRepository.delete(order.getId());
        Result<Order> result = new Result<>();
        result.api(Api.SUCCESS);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private void saveOrderItems(Long userId, Order order, Set<OrderItems> orderItems) {

        User user = userRepository.findOne(userId);
        order.setUser(user);
        Order o = orderRepository.save(order);
        for (OrderItems orderI : orderItems
                ) {
            orderI.setOrder(o);
            orderI.setCreateTime(new Date());
            orderI.setTradeTime(new Date());
            orderItemsRepository.saveAndFlush(orderI);
        }

    }

    @Override
    public List<Order> getWeiZhiFu(String status) {
        return orderRepository.getByStatus(status);
    }

    @Override
    public List<Order> getYiZhiFu(String status) {
        return orderRepository.getByStatus(status);
    }

    @Override
    public ResponseEntity<?> getOrders() {
        List<Order> orders = orderRepository.findAll();
        Result<List<Order>> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(orders);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public Page<Order> list(Pageable pageable) {
        Page<Order> page = orderRepository.findAll(pageable);
        return page;
    }

    @Override
    public ResponseEntity<?> getAllMoney(User user) {
        List<Order> orders = orderRepository.findByUser(user);
        double a = 0;
        for (int i = 0; i < orders.size(); i++) {
            a += orders.get(i).getNeed().getMoney();
        }
        Result<Double> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(a);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
