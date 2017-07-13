package com.neng.service;

import com.neng.pojo.FriendCircle;
import com.neng.repository.FriendCircleRepository;
import com.neng.service.inner.FriendCircleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    @Override
    public ResponseEntity<?> getFriendCricles() {

        return null;
    }

    @Override
    public ResponseEntity<?> save(FriendCircle friendCircle) {
        return null;
    }
}
