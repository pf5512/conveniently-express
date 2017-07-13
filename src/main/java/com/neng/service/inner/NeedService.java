package com.neng.service.inner;

import com.neng.pojo.Need;
import org.springframework.http.ResponseEntity;

/**
 * Created by nengneng on 2017/6/6.
 */
public interface NeedService {

    ResponseEntity<?> getTasks();

    ResponseEntity<?> save(Need need);//用户注册

    ResponseEntity<?> getById(long needId);

    ResponseEntity<?> saveAndFlushNeed(Need need);
}
