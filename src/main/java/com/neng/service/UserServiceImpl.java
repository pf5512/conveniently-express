package com.neng.service;

import com.neng.exception.UserUpdateException;
import com.neng.pojo.Order;
import com.neng.pojo.User;
import com.neng.pojo.UserBuilder;
import com.neng.pojo.config.Api;
import com.neng.pojo.config.Constant;
import com.neng.repository.UserRepository;
import com.neng.service.inner.UserService;
import com.neng.utils.CustomValidator;
import com.neng.utils.RespFactory;
import com.neng.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

/**
 * Created by nengneng on 2017/6/6.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

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
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
        if (!user.isPresent()) {
            if (userRepository.countByUsername(username) < 1) {
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
        } else if (userRepository.countByUsername(username) > 0) {
            return new ResponseEntity<>(new Result<String>().api(Api.USER_NAME_EXIST), HttpStatus.OK);
        } else {
            User u = new User();
            u.setUsername(username);
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
    public ResponseEntity<?> changeStatus(long userId, String status) {

        User u =  userRepository.findOne(userId);
        u.setStatus(status);
        Result<User> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(u);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
