package com.neng.service.inner;

import com.neng.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by nengneng on 2017/6/6.
 */
public interface UserService {

    ResponseEntity<?> login(String username, String password, HttpSession session); //用户登录

    ResponseEntity<?> auth(String username,String password); //获取token

    ResponseEntity<?> register(String username,String password); //用户注册

    ResponseEntity<?> getOne(long userId);

    ResponseEntity<?> getUserNumber(); //获取用户数量

    ResponseEntity<?> saveAndFlush(User user);

    ResponseEntity<?> getUsers();

    ResponseEntity<?> changeStatus(long userId, int status);

    Page<User> list(Pageable pageable);

    ResponseEntity<?> search(String name);

    void uploadAvatar(MultipartFile file,User user);
}
