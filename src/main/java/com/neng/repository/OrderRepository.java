package com.neng.repository;

import com.neng.pojo.Need;
import com.neng.pojo.Order;
import com.neng.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nengneng on 2017/7/13.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);

    Order getByNeed(Need need);

    Order getByNumber(String number);

    List<Order> getByStatus(String status);
}
