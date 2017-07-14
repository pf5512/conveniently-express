package com.neng.service;

import com.neng.pojo.AlwaysLocation;
import com.neng.pojo.User;
import com.neng.pojo.config.Api;
import com.neng.repository.AlwaysLocationRepository;
import com.neng.service.inner.AlwaysLocationService;
import com.neng.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户地址操作类
 * Created by nengneng on 2017/6/6.
 */
@Service
@Slf4j
public class AlwaysLocationServiceImpl implements AlwaysLocationService {
    private AlwaysLocation alwaysLocation;
    private List<AlwaysLocation> alwaysLocations;

    private AlwaysLocationRepository alwaysLocationRepository;

    @Autowired
    public AlwaysLocationServiceImpl(AlwaysLocationRepository alwaysLocationRepository) {
        this.alwaysLocationRepository = alwaysLocationRepository;
    }

    /**
     * 保存更新常用地点
     * @param alwaysLocation
     * @return
     */
    @Override
    public ResponseEntity<?> saveAndFlushAlwaysLocation(AlwaysLocation alwaysLocation) {
        AlwaysLocation alDate = alwaysLocationRepository.saveAndFlush(alwaysLocation);
        Result<AlwaysLocation> result = new Result<AlwaysLocation>();
        result.api(Api.SUCCESS);
        result.setData(alDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 获取位置
     *
     * @param a
     * @return
     */
    @Override
    public ResponseEntity<?> getById(AlwaysLocation a) {
        alwaysLocation = alwaysLocationRepository.getOne(a.getId());
        Result<AlwaysLocation> result = new Result<AlwaysLocation>();
        result.api(Api.SUCCESS);
        result.setData(alwaysLocation);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 获取所有的地址
     *
     * @param user
     * @return
     */
    @Override
    public ResponseEntity<?> getByUser(User user) {
        alwaysLocations = alwaysLocationRepository.getByUser(user);
        Result<List<AlwaysLocation>> result = new Result<List<AlwaysLocation>>();
        result.api(Api.SUCCESS);
        result.setData(alwaysLocations);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 保存地址
     *
     * @param alwaysLocation
     * @return
     */
    @Override
    public ResponseEntity<?> save(AlwaysLocation alwaysLocation) {
        alwaysLocation.setCreateTime(new Date());
        AlwaysLocation alDate = alwaysLocationRepository.save(alwaysLocation);
        Result<AlwaysLocation> result = new Result<AlwaysLocation>();
        result.api(Api.SUCCESS);
        result.setData(alDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
