package com.neng.service;

import com.neng.pojo.ShowOrder;
import com.neng.repository.ShowOrderRepository;
import com.neng.service.inner.ShowOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by nengneng on 2017/7/13.
 */
@Service
@Slf4j
public class ShowOrderServiceImpl implements ShowOrderService {

    private ShowOrderRepository showOrderRepository;

    @Autowired
    public ShowOrderServiceImpl(ShowOrderRepository showOrderRepository) {
        this.showOrderRepository = showOrderRepository;
    }
    @Override
    public ResponseEntity<?> getShowOrders() {
        return null;
    }

    @Override
    public ResponseEntity<?> save(ShowOrder showOrder) {
        return null;
    }
}
