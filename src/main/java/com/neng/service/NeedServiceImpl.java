package com.neng.service;

import com.neng.pojo.Need;
import com.neng.pojo.Order;
import com.neng.pojo.User;
import com.neng.pojo.config.Api;
import com.neng.repository.NeedRepository;
import com.neng.repository.UserRepository;
import com.neng.service.inner.NeedService;
import com.neng.utils.OssConstants;
import com.neng.utils.Result;
import com.neng.utils.UploadFile;
import com.neng.utils.UploadOSSUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by nengneng on 2017/6/6.
 */
@Service
@Slf4j
@Transactional
public class NeedServiceImpl implements NeedService {

    private Need need;

    private NeedRepository needRepository;
    private UserRepository userRepository;

    @Autowired
    public NeedServiceImpl(NeedRepository needRepository,
                           UserRepository userRepository) {
        this.needRepository = needRepository;
        this.userRepository = userRepository;
    }


    /**
     * 获取一个需求
     *
     * @param needId
     * @return
     */
    @Override
    public ResponseEntity<?> getById(long needId) {
        if (needId == 0) {
            Result<Need> result = new Result<>();
            result.api(Api.PARMETER_NOT_EXIT);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        need = needRepository.getOne(needId);
        Result<Need> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(need);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 保存一个需求
     *
     * @param need
     * @return
     */
    @Override
    public ResponseEntity<?> saveAndFlushNeed(Long userId, Need need,MultipartFile file) {
        Result<Need> result = new Result<>();
        if (need == null) {

            result.api(Api.PARMETER_NOT_EXIT);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        if (file.isEmpty()) {
            System.out.println(file.getOriginalFilename() + "sadfasdfasdfasdf");
            result.api(Api.PARMETER_NOT_EXIT);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        try {
            byte[] bytes = file.getBytes();
            String retuen_url = new UploadFile().upload(bytes, file.getOriginalFilename());
            need.setGoodPic(retuen_url);
            User u = userRepository.findOne(userId);
            need.setUser(u);
            Need needDate = needRepository.saveAndFlush(need);
            result.api(Api.SUCCESS);
            result.setData(needDate);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("成功上传");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 获取所有的用户需求
     *
     * @return
     */
    @Override
    public ResponseEntity<?> getNeeds() {
        List<Need> needs = needRepository.findAll();
        Result<List<Need>> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(needs);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 获取用户发布过的所有的需求
     *
     * @param userId
     * @return
     */
    @Override
    public ResponseEntity<?> getNeedsByUser(Long userId) {
        User user = userRepository.findOne(userId);
        if (user == null) {
            Result<Need> result = new Result<>();
            result.api(Api.PARMETER_NOT_EXIT);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        List<Need> needs = needRepository.findByUser(user);
        Result<List<Need>> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(needs);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 获取单个需求
     *
     * @param needId
     * @return
     */
    @Override
    public ResponseEntity<?> getNeed(Long needId) {
        Need need = needRepository.findOne(needId);
        Result<Need> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(need);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 更新需求信息
     *
     * @param userId
     * @param need
     * @param needId
     * @return
     */
    @Override
    public ResponseEntity<?> updateNeed(Long userId, Need need, Long needId) {
        User u = userRepository
                .findOne(userId);
        Need n = needRepository.findOne(needId);

        n.setContent(need.getContent());
        n.setStartLat(need.getStartLat());
        n.setMoney(need.getMoney());
        n.setLimitTime(need.getLimitTime());
        n.setStartLng(need.getStartLng());
        n.setGoodName(need.getGoodName());
        n.setGoodPic(need.getGoodPic()
        );
        n.setGoodPrice(need.getGoodPrice());

        needRepository.saveAndFlush(n);
        Result<Need> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(need);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 删除用户的需求
     *
     * @param userId
     * @param needId
     * @return
     */
    @Override
    public ResponseEntity<?> deleteNeed(Long userId, Long needId) {

        User u = userRepository
                .findOne(userId);
        Need n = needRepository.findOne(needId);

        if (n.getUser().getId() == u.getId()) {
            needRepository.delete(n);
            Result<Need> result = new Result<>();
            result.api(Api.SUCCESS);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            Result<Need> result = new Result<>();
            result.api(Api.NO_PERMISSION);
            return new ResponseEntity<>(result, HttpStatus.NOT_ACCEPTABLE);

        }
    }

    @Override
    public List<Need> getWeiJieDan(String status) {
        return needRepository.getByStatus(status);
    }

    @Override
    public Page<Need> list(Pageable pageable) {
        Page<Need> page = needRepository.findAll(pageable);
        return page;
    }
}
