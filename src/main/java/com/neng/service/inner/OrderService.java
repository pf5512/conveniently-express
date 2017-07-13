package com.neng.service.inner;

import com.neng.pojo.Order;
import org.springframework.http.ResponseEntity;

/**
 * Created by nengneng on 2017/7/13.
 */
public interface OrderService {

    ResponseEntity<?> getOrders();

    ResponseEntity<?> save(Order order);
}
