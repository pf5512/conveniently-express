package com.neng.repository;

import com.neng.pojo.Need;
import com.neng.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nengneng on 2017/7/13.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order getByNeed(Need need);

    Order getByNumber(String number);
}
