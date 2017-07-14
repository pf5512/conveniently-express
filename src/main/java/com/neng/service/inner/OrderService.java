package com.neng.service.inner;

import com.neng.pojo.Need;
import com.neng.pojo.Order;
import com.neng.pojo.OrderItems;
import com.neng.pojo.User;
import org.springframework.http.ResponseEntity;

import java.util.Set;

/**
 * Created by nengneng on 2017/7/13.
 */
public interface OrderService {

    ResponseEntity<?> getOrders(User user);

    ResponseEntity<?> saveAndFlushOrder(Long userId,Order order, Set<OrderItems> orderItems);

    ResponseEntity<?> getOne(long orderId);

    ResponseEntity<?> getByNeed(Need need);

    ResponseEntity<?> getByNumber(String number);
}
