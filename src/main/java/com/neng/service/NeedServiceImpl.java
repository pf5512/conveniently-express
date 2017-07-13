package com.neng.service;

import com.neng.pojo.Need;
import com.neng.pojo.User;
import com.neng.pojo.config.Api;
import com.neng.repository.NeedRepository;
import com.neng.service.inner.NeedService;
import com.neng.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by nengneng on 2017/6/6.
 */
@Service
@Slf4j
public class NeedServiceImpl implements NeedService {

    private Need need;

    private NeedRepository needRepository;

    @Autowired
    public NeedServiceImpl(NeedRepository needRepository) {
        this.needRepository = needRepository;
    }


    /**
     * 获取所有的需求
     * @return
     */
    @Override
    public ResponseEntity<?> getTasks(User user) {
        List<Need> needs = needRepository.findByUser(user);
        Result<List<Need>> result=new Result<>();
        result.api(Api.SUCCESS);
        result.setData(needs);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 获取一个需求
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
     * @param need
     * @return
     */
    @Override
    public ResponseEntity<?> saveAndFlushNeed(Need need) {
        if (need == null) {
            Result<Need> result = new Result<>();
            result.api(Api.PARMETER_NOT_EXIT);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        Need needDate = needRepository.saveAndFlush(need);
        Result<Need> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(needDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
