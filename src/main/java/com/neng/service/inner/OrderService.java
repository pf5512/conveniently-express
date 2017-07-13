package com.neng.service.inner;

import com.neng.pojo.Need;
import com.neng.pojo.Order;
import org.springframework.http.ResponseEntity;

/**
 * Created by nengneng on 2017/7/13.
 */
public interface OrderService {

    ResponseEntity<?> getOrders();

    ResponseEntity<?> save(Order order);

    ResponseEntity<?> saveAndFlushOrder(Order order);

    ResponseEntity<?> getOne(long orderId);

    ResponseEntity<?> getByNeed(Need need);

    ResponseEntity<?> getByNumber(String number);
}
