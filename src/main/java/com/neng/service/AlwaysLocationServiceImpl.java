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

import java.util.List;

/**
 *
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
     * @param lat
     * @param lng
     * @param user
     * @param type
     * @return
     */
    @Override
    public ResponseEntity<?> saveAndFlushAlwaysLocation(String location,String lat, String lng, User user, String type) {
        alwaysLocation = new AlwaysLocation();
        alwaysLocation.setLat(lat);
        alwaysLocation.setLng(lng);
        alwaysLocation.setLocation(location);
        alwaysLocation.setUser(user);
        alwaysLocation.setType(type);
        AlwaysLocation alDate = alwaysLocationRepository.saveAndFlush(alwaysLocation);
        Result<AlwaysLocation> result = new Result<AlwaysLocation>();
        result.api(Api.SUCCESS);
        result.setData(alDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 获取位置
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
}
