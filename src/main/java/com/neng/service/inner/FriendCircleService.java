package com.neng.service.inner;

import com.neng.pojo.FriendCircle;
import com.neng.pojo.User;
import org.springframework.http.ResponseEntity;

/**
 * Created by nengneng on 2017/7/13.
 */

public interface FriendCircleService {

    ResponseEntity<?> getFriendCricles(User user);

    ResponseEntity<?> save(User user,FriendCircle friendCircle);
}
