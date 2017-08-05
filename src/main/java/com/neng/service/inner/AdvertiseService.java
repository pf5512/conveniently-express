package com.neng.service.inner;

import com.neng.pojo.Advertise;
import com.neng.pojo.AlwaysLocation;
import com.neng.pojo.Need;
import com.neng.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

/**
 * Created by nengneng on 2017/8/5.
 */
public interface AdvertiseService {

    ResponseEntity<?> saveAndFlushAdvertise(Advertise advertise);

    ResponseEntity<?> getById(Advertise advertise);

    ResponseEntity<?> save(Advertise advertise);

    Page<Advertise> list(Pageable pageable);

    ResponseEntity<?> update(Long advertiseId,String title, String content);
}
