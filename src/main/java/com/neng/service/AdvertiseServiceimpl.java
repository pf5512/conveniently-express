package com.neng.service;

import com.neng.pojo.Advertise;
import com.neng.pojo.Need;
import com.neng.pojo.config.Api;
import com.neng.repository.AdvertiseRepository;
import com.neng.service.inner.AdvertiseService;
import com.neng.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nengneng on 2017/8/5.
 */

@Service
public class AdvertiseServiceimpl implements AdvertiseService {


    Result<Advertise> result = new Result<>();
    Result<List<Advertise>> results = new Result<>();
    Advertise advertise = new Advertise();
    List<Advertise> advertises = new ArrayList<>();
    private AdvertiseRepository advertiseRepository;



    @Autowired
    public AdvertiseServiceimpl(AdvertiseRepository advertiseRepository) {

        this.advertiseRepository = advertiseRepository;
    }

    @Override
    public ResponseEntity<?> saveAndFlushAdvertise(Advertise advertise) {

        return null;
    }

    /**
     * 通过ID 查找广告
     *
     * @param advertise
     * @return
     */
    @Override
    public ResponseEntity<?> getById(Advertise advertise) {
        if (advertise == null) {
            result.api(Api.PARMETER_NOT_EXIT);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        advertise = advertiseRepository.findOne(advertise.getId());
        result.setData(advertise);
        result.api(Api.SUCCESS);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 保存广告
     * @param advertise
     * @return
     */
    @Override
    public ResponseEntity<?> save(Advertise advertise) {
        if (advertise == null) {
            result.api(Api.PARMETER_NOT_EXIT);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        advertise = advertiseRepository.save(advertise);
        result.setData(advertise);
        result.api(Api.SUCCESS);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 广告列表
     * @param pageable
     * @return
     */
    @Override
    public Page<Advertise> list(Pageable pageable) {
        Page<Advertise> page = advertiseRepository.findAll(pageable);
        return page;
    }

    /**
     * 更新广告
     * @param advertiseId
     * @param title
     * @param content
     * @return
     */
    @Override
    public ResponseEntity<?> update(Long advertiseId, String title, String content) {
        advertise = advertiseRepository.findOne(advertiseId);
        advertise.setContent(content);
        advertise.setTitle(title);
        advertise.setCreateTime(new Date());
        Advertise advertiseDate = advertiseRepository.saveAndFlush(advertise);
        result.setData(advertiseDate);
        result.api(Api.SUCCESS);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}
