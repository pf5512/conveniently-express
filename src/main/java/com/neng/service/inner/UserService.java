package com.neng.service.inner;

import com.neng.pojo.User;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by nengneng on 2017/6/6.
 */
public interface UserService {

    ResponseEntity<?> login(String username, String password, HttpSession session);//用户登录

    ResponseEntity<?> auth(String username,String password);//获取token

    ResponseEntity<?> register(String username,String password);//用户注册


}
