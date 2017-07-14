package com.neng.service;

import com.neng.pojo.AlwaysLocation;
import com.neng.pojo.FriendCircle;
import com.neng.pojo.Need;
import com.neng.pojo.User;
import com.neng.pojo.config.Api;
import com.neng.repository.FriendCircleRepository;
import com.neng.repository.UserRepository;
import com.neng.service.inner.FriendCircleService;
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
public class FriendCircleServiceImpl implements FriendCircleService {

    private FriendCircleRepository fc;

    private UserRepository userRepository;

    @Autowired
    public FriendCircleServiceImpl(FriendCircleRepository fc,
                                   UserRepository userRepository) {
        this.fc = fc;
        this.userRepository = userRepository;
    }

    /**
     * 获取所有的朋友圈列表
     *
     * @return
     */
    @Override
    public ResponseEntity<?> getFriendCricles() {

        List<FriendCircle> friendCircles = fc.findAll();
        Result<List<FriendCircle>> result = new Result<List<FriendCircle>>();
        result.api(Api.SUCCESS);
        result.setData(friendCircles);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 获取用户发布的朋友圈
     * @param userId
     * @return
     */
    @Override
    public ResponseEntity<?> getFriendCriclesByUser(Long userId) {
        User u = userRepository.findOne(userId);
        List<FriendCircle> friendCircles = fc.findByUser(u);
        Result<List<FriendCircle>> result = new Result<List<FriendCircle>>();
        result.api(Api.SUCCESS);
        result.setData(friendCircles);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 发布朋友圈
     * @param userId
     * @param friendCircle
     * @return
     */
    @Override
    public ResponseEntity<?> save(Long userId,FriendCircle friendCircle) {
        if (friendCircle == null) {
            Result<FriendCircle> result = new Result<>();
            result.api(Api.PARMETER_NOT_EXIT);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        User u = userRepository.findOne(userId);
        friendCircle.setUser(u);
        fc.save(friendCircle);
        Result<FriendCircle> result = new Result<>();
        result.api(Api.SUCCESS);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 删除朋友圈
     * @param userId
     * @param friendId
     * @return
     */
    @Override
    public ResponseEntity<?> deleteFriend(Long userId, Long friendId) {
        User u = userRepository
                .findOne(userId);
        FriendCircle friendCircle = fc.findOne(friendId);

        if (friendCircle.getUser().getId() == u.getId()) {
            fc.delete(friendCircle);
            Result<FriendCircle> result = new Result<>();
            result.api(Api.SUCCESS);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            Result<FriendCircle> result = new Result<>();
            result.api(Api.NO_PERMISSION);
            return new ResponseEntity<>(result, HttpStatus.NOT_ACCEPTABLE);

        }
    }
}
