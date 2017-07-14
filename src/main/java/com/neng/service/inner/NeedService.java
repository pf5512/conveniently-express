package com.neng.service.inner;

import com.neng.pojo.Need;
import com.neng.pojo.User;
import org.springframework.http.ResponseEntity;

/**
 * Created by nengneng on 2017/6/6.
 */
public interface NeedService {


    ResponseEntity<?> getById(long needId);

    ResponseEntity<?> saveAndFlushNeed(Long userId,Need need);

    ResponseEntity<?> getNeeds();

    ResponseEntity<?> getNeedsByUser(Long userId);

    ResponseEntity<?> getNeed(Long needId);

    ResponseEntity<?> updateNeed(Long userId, Need need, Long needId);

    ResponseEntity<?> deleteNeed(Long userId, Long needId);
}
