package com.neng.service;

import com.neng.pojo.AlwaysLocation;
import com.neng.pojo.User;
import com.neng.pojo.config.Api;
import com.neng.repository.AlwaysLocationRepository;
import com.neng.service.inner.AlwaysLocationService;
import com.neng.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nengneng on 2017/6/6.
 */
@Service
public class AlwaysLocationServiceImpl implements AlwaysLocationService {
    private AlwaysLocation alwaysLocation;

    private AlwaysLocationRepository alwaysLocationRepository;

    @Autowired
    public AlwaysLocationServiceImpl(AlwaysLocationRepository alwaysLocationRepository) {
        this.alwaysLocationRepository = alwaysLocationRepository;
    }

    @Override
    public ResponseEntity<?> saveAndFlushAlwaysLocation(String lat, String lng, User user, String type) {
        alwaysLocation.setLat(lat);
        alwaysLocation.setLng(lng);
        alwaysLocation.setUser(user);
        alwaysLocation.setType(type);
        alwaysLocationRepository.saveAndFlush(alwaysLocation);
        Result<AlwaysLocation> result = new Result<AlwaysLocation>();
        result.api(Api.SUCCESS);
        result.setCode(1);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getById(AlwaysLocation a) {
        alwaysLocation = alwaysLocationRepository.getOne(a.getId());
        Result<AlwaysLocation> result = new Result<AlwaysLocation>();
        result.api(Api.SUCCESS);
        result.setData(alwaysLocation);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
