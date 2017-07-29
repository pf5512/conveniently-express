package com.neng.service;

import com.neng.exception.UserUpdateException;
import com.neng.pojo.User;
import com.neng.pojo.config.Api;
import com.neng.pojo.config.Constant;
import com.neng.pojo.enumClass.StatusEnum;
import com.neng.repository.UserRepository;
import com.neng.service.inner.UserService;
import com.neng.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by nengneng on 2017/6/6.
 */
@Service
@Transactional
public class UserServiceImpl implements UserDetailsService,UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public ResponseEntity<?> login(String username, String password, HttpSession session) {
        if (CustomValidator.hasEmpty(username, password)) {
            return RespFactory.INSTANCE().paramsError();
        }
        Optional<User> user = userRepository.findByNameAndPassword(username, password);
        if (!user.isPresent()) {
            if (userRepository.countByName(username) < 1) {
                return new ResponseEntity<>(new Result<String>().api(Api.USER_NOT_EXIST), HttpStatus.OK);
            }
            return new ResponseEntity<>(new Result<String>().api(Api.USER_PASS_ERR), HttpStatus.OK);
        } else {
            User userData = user.get();
            Result<User> result = new Result<>();
            result.api(Api.SUCCESS);
            result.setData(userData);
            session.setAttribute(Constant.USER_SESSION, userData);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> auth(String username, String password) {
        return null;
    }

    @Override
    public ResponseEntity<?> register(String username, String password) {
        if (CustomValidator.hasEmpty(username, password)) {
            return RespFactory.INSTANCE().paramsError();
        } else if (userRepository.countByName(username) > 0) {
            return new ResponseEntity<>(new Result<String>().api(Api.USER_NAME_EXIST), HttpStatus.OK);
        } else {
            User u = new User();
            u.setName(username);
            u.setPassword(password);
            User user = userRepository.save(u);

            if (user == null || user.getId() == 0) {
                throw new UserUpdateException();
            }

            Result<User> result = new Result<>();
            result.api(Api.SUCCESS);
            result.setData(user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> getUserNumber() {
        Integer userNum = userRepository.findAll().size();
        Result<Integer> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(userNum);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getOne(long userId) {
        User u =  userRepository.findOne(userId);
        Result<User> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(u);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> saveAndFlush(User user) {

        User u =  userRepository.saveAndFlush(user);
        Result<User> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(u);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getUsers() {
        List<User> users = userRepository.findAll();
        Result<List<User>> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(users);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> changeStatus(long userId, int status) {

        User u =  userRepository.findOne(userId);
        Result<User> result = changeUserStatus(u, status);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private Result<User> changeUserStatus(User u, int status) {

        if (status == StatusEnum.ACTIVE.getCode()) {
            u.setStatus(StatusEnum.FREEZE.getCode());
        } else {
            u.setStatus(StatusEnum.ACTIVE.getCode());
        }
        userRepository.saveAndFlush(u);
        Result<User> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(u);
        return result;
    }

    @Override
    public Page<User> list(Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable);
        return page;
    }

    @Override
    public ResponseEntity<?> search(String name) {
        Result<User> result = new Result<>();
        if (name == null) {
            result.api(Api.PARMETER_NOT_EXIT);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        User u = userRepository.findUserByName(name);
        if (u == null) {
            result.api(Api.NO_USERS);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        result.api(Api.SUCCESS);
        result.setData(u);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findUserByName(s);
    }


    @Override
    public void uploadAvatar(MultipartFile file,User user) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String newFileName = "用户头像/" + df.format(new Date()) + "_"
                + file.getOriginalFilename();
        if (file.getSize() != 0) {
            new UploadOSSUtil();
            try {
                UploadOSSUtil.uploadImgAliyun(file.getInputStream(), newFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            user.setHeadPic(OssConstants.THIRD_PARTY_PIC_SAVEURL + newFileName);
            userRepository.save(user);
        }else {
            user.setHeadPic(null);
            userRepository.save(user);
        }

    }
}
