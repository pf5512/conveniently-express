package com.neng.service;

import com.neng.pojo.ShowOrder;
import com.neng.pojo.User;
import com.neng.pojo.config.Api;
import com.neng.repository.ShowOrderRepository;
import com.neng.service.inner.ShowOrderService;
import com.neng.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 获取用户的所有晒单
     * @param user
     * @return
     */
    @Override
    public ResponseEntity<?> getShowOrders(User user) {
        List<ShowOrder> showOrders = showOrderRepository.findByUser(user);
        Result<List<ShowOrder>> result = new Result<List<ShowOrder>>();
        result.api(Api.SUCCESS);
        result.setData(showOrders);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    /**
     * 保存用户的晒单
     * @param user
     * @param showOrder
     * @return
     */
    @Override
    public ResponseEntity<?> save(User user, ShowOrder showOrder) {
        showOrder.setUser(user);
        showOrderRepository.save(showOrder);
        Result<ShowOrder> result = new Result<ShowOrder>();
        result.api(Api.SUCCESS);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
