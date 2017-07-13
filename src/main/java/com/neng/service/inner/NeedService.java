package com.neng.service.inner;

import com.neng.pojo.Need;
import com.neng.pojo.User;
import org.springframework.http.ResponseEntity;

/**
 * Created by nengneng on 2017/6/6.
 */
public interface NeedService {

    ResponseEntity<?> getTasks(User user);

    ResponseEntity<?> getById(long needId);

    ResponseEntity<?> saveAndFlushNeed(Need need);
}
