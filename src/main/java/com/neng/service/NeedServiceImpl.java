package com.neng.service;

import com.neng.pojo.Need;
import com.neng.pojo.config.Api;
import com.neng.repository.NeedRepository;
import com.neng.service.inner.NeedService;
import com.neng.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by nengneng on 2017/6/6.
 */
@Service
public class NeedServiceImpl implements NeedService {

    private NeedRepository needRepository;

    @Autowired
    public NeedServiceImpl(NeedRepository needRepository){
        this.needRepository = needRepository;
    }


    @Override
    public ResponseEntity<?> getTasks() {
        List<Need> needs = needRepository.findAll();
        Result<List<Need>> result=new Result<>();
        result.api(Api.SUCCESS);
        result.setData(needs);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> save(Need need) {
        Need needDate = needRepository.save(need);
        Result<Need> result=new Result<>();
        result.api(Api.SUCCESS);
        result.setData(needDate);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
