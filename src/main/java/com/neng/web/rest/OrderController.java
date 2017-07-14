package com.neng.web.rest;

import com.neng.service.inner.NeedService;
import com.neng.service.inner.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhubuqing on 2017/7/14.
 */
@RestController
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private OrderService orderService;

    private NeedService needService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public OrderController(NeedService needService) {
        this.needService = needService;
    }
}
