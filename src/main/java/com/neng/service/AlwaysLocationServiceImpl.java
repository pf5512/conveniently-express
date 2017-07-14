package com.neng.service;

import com.neng.pojo.AlwaysLocation;
import com.neng.pojo.FriendCircle;
import com.neng.pojo.User;
import com.neng.pojo.config.Api;
import com.neng.repository.AlwaysLocationRepository;
import com.neng.repository.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    public AlwaysLocationServiceImpl(AlwaysLocationRepository alwaysLocationRepository,
                                     UserRepository userRepository) {
        this.alwaysLocationRepository = alwaysLocationRepository;
        this.userRepository = userRepository;
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
     * @param userId
     * @param alwaysLocation
     * @return
     */
    @Override
    public ResponseEntity<?> save(Long userId,AlwaysLocation alwaysLocation) {
        if (alwaysLocation == null) {
            Result<AlwaysLocation> result = new Result<>();
            result.api(Api.PARMETER_NOT_EXIT);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        User u = userRepository.findOne(userId);
        alwaysLocation.setUser(u);
        alwaysLocation.setCreateTime(new Date());
        AlwaysLocation alDate = alwaysLocationRepository.save(alwaysLocation);
        Result<AlwaysLocation> result = new Result<AlwaysLocation>();
        result.api(Api.SUCCESS);
        result.setData(alDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 获取所有的地址
     * @param userId
     * @return
     */
    @Override
    public ResponseEntity<?> getHomeAddresses(Long userId) {
        User u = userRepository.findOne(userId);
        if (u == null) {
            Result<AlwaysLocation> result = new Result<>();
            result.api(Api.PARMETER_NOT_EXIT);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        List<AlwaysLocation> alwaysLocations = alwaysLocationRepository.getByUser(u);
        Result<List<AlwaysLocation>> result = new Result<List<AlwaysLocation>>();
        result.api(Api.SUCCESS);
        result.setData(alwaysLocations);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 修改地址
     * @param alcationId
     * @param alwaysLocation
     * @return
     */
    @Override
    public ResponseEntity<?> updateHomeAddress(Long alcationId, AlwaysLocation alwaysLocation) {
        if (alwaysLocation == null) {
            Result<AlwaysLocation> result = new Result<>();
            result.api(Api.PARMETER_NOT_EXIT);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        AlwaysLocation location = alwaysLocationRepository.findOne(alcationId);
        location.setLocation(alwaysLocation.getLocation());
        location.setLat(alwaysLocation.getLat()
        );
        location.setLng(alwaysLocation.getLng());
        AlwaysLocation alDate = alwaysLocationRepository.saveAndFlush(location);
        Result<AlwaysLocation> result = new Result<AlwaysLocation>();
        result.api(Api.SUCCESS);
        result.setData(alDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 删除地址
     * @param userId
     * @param addressId
     * @return
     */
    @Override
    public ResponseEntity<?> deleteAAddress(Long userId, Long addressId) {
        User u = userRepository
                .findOne(userId);
        AlwaysLocation alwaysLocation = alwaysLocationRepository.findOne(addressId);

        if (alwaysLocation.getUser().getId() == u.getId()) {
            alwaysLocationRepository.delete(alwaysLocation);
            Result<AlwaysLocation> result = new Result<>();
            result.api(Api.SUCCESS);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            Result<AlwaysLocation> result = new Result<>();
            result.api(Api.NO_PERMISSION);
            return new ResponseEntity<>(result, HttpStatus.NOT_ACCEPTABLE);

        }
    }
}
