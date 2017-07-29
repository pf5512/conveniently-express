package com.neng.service.inner;

import com.neng.pojo.Need;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by nengneng on 2017/6/6.
 */
public interface NeedService {


    ResponseEntity<?> getById(long needId);

    ResponseEntity<?> saveAndFlushNeed(Long userId,Need need,MultipartFile file);

    ResponseEntity<?> getNeeds();

    ResponseEntity<?> getNeedsByUser(Long userId);

    ResponseEntity<?> getNeed(Long needId);

    ResponseEntity<?> updateNeed(Long userId, Need need, Long needId);

    ResponseEntity<?> deleteNeed(Long userId, Long needId);

    List<Need> getWeiJieDan(String status);

    Page<Need> list(Pageable pageable);
}
