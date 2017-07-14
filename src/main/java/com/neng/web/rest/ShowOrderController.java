package com.neng.web.rest;

import com.neng.config.ApiConf;
import com.neng.pojo.ShowOrder;
import com.neng.service.inner.ShowOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by zhubuqing on 2017/7/14.
 */
@RestController
public class ShowOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ShowOrderController.class);

    private ShowOrderService showOrderService;

    @Autowired
    public ShowOrderController(ShowOrderService showOrderService) {
        this.showOrderService = showOrderService;
    }

    @PostMapping(value = ApiConf.saveShowOrder, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> saveShowOrder(@RequestParam ShowOrder showOrder, HttpSession session) {
        logger.info("晒单啦***************************");
        return showOrderService.save(showOrder);
    }

    @PostMapping(value = ApiConf.getShowOrders, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getShowOrders(HttpSession session) {
        logger.info("显示全部晒单啦***************************");
        return showOrderService.getAll();
    }

    @PostMapping(value = ApiConf.getShowOrderByBuyerId, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getShowOrderByBuyerId(@RequestParam long buyerId, HttpSession session) {
        logger.info("显示买家全部晒单啦***************************");
        return showOrderService.getByBuyerId(buyerId);
    }

    @PostMapping(value = ApiConf.getShowOrderBySalerId, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getShowOrderBySalerId(@RequestParam long salerId, HttpSession session) {
        logger.info("显示买家全部晒单啦***************************");
        return showOrderService.getBySalerId(salerId);
    }

    @PostMapping(value = ApiConf.deleteShowOrder, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> deleteShowOrder(@RequestParam ShowOrder showOrder, HttpSession session) {
        logger.info("删除单个晒单啦***************************");
        return showOrderService.deleteShowOrder(showOrder);
    }
}
