package com.neng.web.rest;

import com.neng.config.ApiConf;
import com.neng.pojo.Need;
import com.neng.pojo.User;
import com.neng.service.inner.NeedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nengneng on 2017/6/7.
 */

@RestController
public class TaskController {


    private static final Logger logger= LoggerFactory.getLogger(TaskController.class);


    private NeedService needService;

    @Autowired
    public TaskController(NeedService needService) {
        this.needService = needService;
    }

    @PostMapping(value = ApiConf.saveTask,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> saveTask(Need need){
        logger.info("need***************************");
        User user = new User();
        return needService.saveAndFlushNeed(need);
    }

    @GetMapping(value = ApiConf.getTasks,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getTasks(){
        logger.info("get tasks***************************");
        User user = new User();
        return needService.getTasks(user);
    }


}
