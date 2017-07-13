package com.neng.service;

import com.neng.pojo.AlwaysLocation;
import com.neng.pojo.FriendCircle;
import com.neng.pojo.User;
import com.neng.pojo.config.Api;
import com.neng.repository.FriendCircleRepository;
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

    @Autowired
    public FriendCircleServiceImpl(FriendCircleRepository fc) {
        this.fc = fc;
    }

    /**
     * 获取所有的朋友圈列表
     * @param user
     * @return
     */
    @Override
    public ResponseEntity<?> getFriendCricles(User user) {

        List<FriendCircle> friendCircles = fc.findByUser(user);
        Result<List<FriendCircle>> result = new Result<List<FriendCircle>>();
        result.api(Api.SUCCESS);
        result.setData(friendCircles);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 发布朋友圈
     * @param user
     * @param friendCircle
     * @return
     */
    @Override
    public ResponseEntity<?> save(User user,FriendCircle friendCircle) {

        friendCircle.setUser(user);
        fc.save(friendCircle);
        Result<FriendCircle> result = new Result<>();
        result.api(Api.SUCCESS);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
