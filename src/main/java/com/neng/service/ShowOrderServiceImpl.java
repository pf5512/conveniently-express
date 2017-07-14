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
     * 保存用户的晒单
     *
     * @param showOrder
     * @return
     */
    @Override
    public ResponseEntity<?> save(ShowOrder showOrder) {
        showOrderRepository.save(showOrder);
        Result<ShowOrder> result = new Result<ShowOrder>();
        result.api(Api.SUCCESS);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 获取所有晒单
     *
     * @return
     */
    @Override
    public ResponseEntity<?> getAll() {
        List<ShowOrder> showOrders = showOrderRepository.findAll();
        Result<List<ShowOrder>> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(showOrders);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 获取买家晒单
     *
     * @param buyerId
     * @return
     */
    @Override
    public ResponseEntity<?> getByBuyerId(long buyerId) {
        List<ShowOrder> showOrders = showOrderRepository.getByBuyerId(buyerId);
        Result<List<ShowOrder>> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(showOrders);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 获取买家晒单
     *
     * @param salerId
     * @return
     */
    @Override
    public ResponseEntity<?> getBySalerId(long salerId) {
        List<ShowOrder> showOrders = showOrderRepository.getBySalerId(salerId);
        Result<List<ShowOrder>> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(showOrders);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 删除单个晒单
     *
     * @param showOrder
     * @return
     */
    @Override
    public ResponseEntity<?> deleteShowOrder(ShowOrder showOrder) {
        showOrderRepository.delete(showOrder.getId());
        Result<ShowOrder> result = new Result<>();
        result.api(Api.SUCCESS);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
