package com.neng.service.inner;

import com.neng.pojo.Order;
import com.neng.pojo.ShowOrder;
import org.springframework.http.ResponseEntity;

/**
 * Created by nengneng on 2017/7/13.
 */
public interface ShowOrderService {

    ResponseEntity<?> getShowOrders();

    ResponseEntity<?> save(ShowOrder showOrder);
}
