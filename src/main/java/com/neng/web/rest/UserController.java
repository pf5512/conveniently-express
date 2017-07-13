package com.neng.web.rest;

import com.neng.config.ApiConf;
//import com.neng.service.InitServiceImpl;
import com.neng.service.inner.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nengneng on 2017/6/6.
 */
@RestController
public class UserController {

    private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = ApiConf.login,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password){
        logger.info("登录进来啦***************************");
        return userService.login(username,password);
    }


    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = ApiConf.register,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> register(@RequestParam String username,@RequestParam String password){
        logger.info("注册进来啦***************************");
        return userService.register(username,password);
    }
}
