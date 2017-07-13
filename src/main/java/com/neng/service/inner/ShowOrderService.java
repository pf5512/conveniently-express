package com.neng.service.inner;

import com.neng.pojo.Order;
import com.neng.pojo.ShowOrder;
import com.neng.pojo.User;
import org.springframework.http.ResponseEntity;

/**
 * Created by nengneng on 2017/7/13.
 */
public interface ShowOrderService {

    ResponseEntity<?> getShowOrders(User user);

    ResponseEntity<?> save(User user,ShowOrder showOrder);
}
