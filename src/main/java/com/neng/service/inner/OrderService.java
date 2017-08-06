package com.neng.service.inner;

import com.neng.pojo.Need;
import com.neng.pojo.Order;
import com.neng.pojo.OrderItems;
import com.neng.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

/**
 * Created by nengneng on 2017/7/13.
 */
public interface OrderService {

    ResponseEntity<?> getOrdersByUser(User user);

    ResponseEntity<?> saveAndFlushOrder(Long userId, Order order);

    ResponseEntity<?> getOne(long orderId);

    ResponseEntity<?> getByNeed(Need need);

    ResponseEntity<?> getByNumber(String number);

    ResponseEntity<?> delete(Order order);

    List<Order> getWeiZhiFu(String status);

    List<Order> getYiZhiFu(String status);

    ResponseEntity<?> getOrders();

    Page<Order> list(Pageable pageable);

    ResponseEntity<?> getAllMoney(User user);
}
