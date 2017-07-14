package com.neng.web.rest;

import com.neng.config.ApiConf;
import com.neng.pojo.Need;
import com.neng.pojo.Order;
import com.neng.pojo.OrderItems;
import com.neng.service.inner.NeedService;
import com.neng.service.inner.OrderService;
import com.neng.service.inner.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * 订单 endpoints
 * Created by nengneng on 2017/6/7.
 */

@RestController
public class OrderController {


    private static final Logger logger= LoggerFactory.getLogger(OrderController.class);


    private OrderService orderService;
    private UserService userService;

    @Autowired
    public OrderController(OrderService orderService,
                           UserService userService
                           ) {
        this.orderService = orderService;
        this.userService = userService;
    }

    /**
     * 保存一个订单
      * @param userId
     * @param order
     * @return
     */
    @PostMapping(value = ApiConf.receiveOrder,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> saveOrder(Long userId, Order order, Set<OrderItems> orderItems){
        logger.info("save Order***************************");
        return orderService.saveAndFlushOrder(userId,order,orderItems);
    }






}
