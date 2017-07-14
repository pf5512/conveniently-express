package com.neng.web.rest;

import com.neng.config.ApiConf;
import com.neng.pojo.Order;
import com.neng.pojo.OrderItems;
import com.neng.pojo.User;
import com.neng.service.inner.OrderItemsService;
import com.neng.service.inner.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * Created by zhubuqing on 2017/7/14.
 */
@RestController
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private OrderService orderService;

    private OrderItemsService orderItemsService;

    @Autowired
    public OrderController(OrderService orderService, OrderItemsService orderItemsService) {
        this.orderService = orderService;
        this.orderItemsService = orderItemsService;
    }

    /**
     * 接单
     *
     * @param order
     * @param orderItemss
     * @param session
     * @return
     */
    @PostMapping(value = ApiConf.receiveOrder, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> receiveOrder(@RequestParam Order order, @RequestParam Set<OrderItems> orderItemss, HttpSession session) {
        logger.info("接单啦***************************");
        return orderService.saveAndFlushOrder(order.getUser().getId(), order, orderItemss);
    }

    @PostMapping(value = ApiConf.cancelOrder, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> cancelOrder(@RequestParam Order order, HttpSession session) {
        logger.info("删除订单啦***************************");
        return orderService.delete(order);
    }

    @PostMapping(value = ApiConf.getOrders, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getOrders(@RequestParam User user, HttpSession session) {
        logger.info("获取所有订单啦***************************");
        return orderService.getOrders(user);
    }

    @PostMapping(value = ApiConf.getOrderItems, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getOrderItems(@RequestParam Order order, HttpSession session) {
        logger.info("获取所有订单列表啦***************************");
        return orderItemsService.getByOrder(order);
    }

    @PostMapping(value = ApiConf.getOrderItem, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getOrderItem(@RequestParam OrderItems orderItems, HttpSession session) {
        logger.info("获取单个订单详情啦***************************");
        return orderItemsService.getOne(orderItems.getId());
    }
}