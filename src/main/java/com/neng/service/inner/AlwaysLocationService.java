package com.neng.service.inner;

import com.neng.pojo.AlwaysLocation;
import com.neng.pojo.User;
import org.springframework.http.ResponseEntity;

/**
 * Created by nengneng on 2017/6/6.
 */
public interface AlwaysLocationService {
    ResponseEntity<?> saveAndFlushAlwaysLocation(String location,String lat, String lng, User user, String type);

    ResponseEntity<?> getById(AlwaysLocation alwaysLocation);

    ResponseEntity<?> getByUser(User user);
}
