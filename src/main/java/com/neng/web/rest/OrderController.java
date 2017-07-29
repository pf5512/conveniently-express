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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * Created by zhubuqing on 2017/7/14.
 */
@RestController
@CrossOrigin(origins = "*")
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

    /**
     * 取消订单
     * @param order
     * @param session
     * @return
     */
    @PostMapping(value = ApiConf.cancelOrder, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> cancelOrder(@RequestParam Order order, HttpSession session) {
        logger.info("删除订单啦***************************");
        return orderService.delete(order);
    }

    /**
     * 获取用户的订单
     * @param user
     * @param session
     * @return
     */
    @PostMapping(value = ApiConf.getOrdersByUser, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getOrdersByUser(@RequestParam User user, HttpSession session) {
        logger.info("获取用户的所有订单啦***************************");
        return orderService.getOrdersByUser(user);
    }

    /**
     * 获取所有的订单
     * @return
     */
    @GetMapping(value = ApiConf.getOrders, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getOrders() {
        logger.info("获取所有订单啦***************************");
        return orderService.getOrders();
    }

    /**
     * 获取所有的订单列表
     * @param id
     * @param session
     * @return
     */
    @GetMapping(value = ApiConf.getOrderItems, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getOrderItems(@PathVariable("id") Long id, HttpSession session) {
        logger.info("获取所有订单列表啦***************************");
        return orderItemsService.getByOrderId(id);
    }

    /**
     * 获取单个订单的详情
     * @param orderItems
     * @param session
     * @return
     */
    @PostMapping(value = ApiConf.getOrderItem, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getOrderItem(@RequestParam OrderItems orderItems, HttpSession session) {
        logger.info("获取单个订单详情啦***************************");
        return orderItemsService.getOne(orderItems.getId());
    }

    /**
     * 获取已接单未支付订单
     *
     * @param status
     * @param model
     * @param session
     * @return
     */
    @PostMapping(value = ApiConf.getWeiZhiFu, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getWeiZhiFu(@PathVariable("status") String status, Model model, HttpSession session) {
        List<Order> orders = orderService.getWeiZhiFu(status);
        model.addAttribute("orders", orders);
        return "";
    }

    /**
     * 获取已支付订单
     *
     * @param status
     * @param model
     * @param session
     * @return
     */
    @GetMapping(value = ApiConf.getYiZhiFu, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getYiZhiFu(@PathVariable("status") String status, Model model, HttpSession session) {
        List<Order> orders = orderService.getYiZhiFu(status);
        model.addAttribute("orders", orders);
        return "";
    }


    @GetMapping(value = ApiConf.getAllMoney, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getAllMoney(@RequestParam User user, HttpSession session) {
        return orderService.getAllMoney(user);
    }

    /**
     * 查询订单信息
     * @param number
     * @return
     */
    @GetMapping(value = ApiConf.order_search, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> user_search(@RequestParam("number") String number) {
        return orderService.getByNumber(number);
    }
}
