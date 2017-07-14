package com.neng.service.inner;

import com.neng.pojo.AlwaysLocation;
import com.neng.pojo.User;
import org.springframework.http.ResponseEntity;

/**
 * Created by nengneng on 2017/6/6.
 */
public interface AlwaysLocationService {
    ResponseEntity<?> saveAndFlushAlwaysLocation(AlwaysLocation alwaysLocation);

    ResponseEntity<?> getById(AlwaysLocation alwaysLocation);

    ResponseEntity<?> getByUser(User user);

    ResponseEntity<?> save(Long userId,AlwaysLocation alwaysLocation);

    ResponseEntity<?> getHomeAddresses(Long userId);

    ResponseEntity<?> updateHomeAddress(Long alocationId, AlwaysLocation alwaysLocation);

    ResponseEntity<?> deleteAAddress(Long userId, Long addressId);
}
