package com.neng.web.rest;

import com.neng.config.ApiConf;
import com.neng.pojo.FriendCircle;
import com.neng.pojo.Need;
import com.neng.pojo.User;
import com.neng.repository.FriendCircleRepository;
import com.neng.repository.UserRepository;
import com.neng.service.inner.FriendCircleService;
import com.neng.service.inner.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nengneng on 2017/7/14.
 */
@RestController
public class FriendCircleController {

    private static final Logger logger= LoggerFactory.getLogger(NeedController.class);

    private FriendCircleService friendCircleService;

    private UserService userService;

    @Autowired
    public FriendCircleController(FriendCircleService friendCircleService,
                                  UserService userService) {
        this.friendCircleService = friendCircleService;
        this.userService = userService;
    }


    /**
     * 保存一个朋友圈发布
     * @param userId
     * @param friendCircle
     * @return
     */
    @PostMapping(value = ApiConf.saveFriendCirle,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> saveFriend(Long userId, FriendCircle friendCircle){
        logger.info("save friendCircle***************************");
        return friendCircleService.save(userId,friendCircle);
    }

    /**
     * 获取所有的朋友圈发布
     * @return
     */
    @GetMapping(value = ApiConf.getFriendCircles,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getFriends(){
        logger.info("get friendCircles***************************");
        return friendCircleService.getFriendCricles();
    }


    /**
     * 获取用户的的朋友圈发布
     * @return
     */
    @GetMapping(value = ApiConf.getFriendCircleByUser,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getFriendsByUser(Long userId){
        logger.info("get friendCircles By user***************************");
        return friendCircleService.getFriendCriclesByUser(userId);
    }


    /**
     * 删除用户朋友圈
     * @param userId
     * @param friendId
     * @return
     */
    @DeleteMapping(value = ApiConf.deleteFriendCircle,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteFriend(Long userId, Long friendId) {
        logger.info("delete friend by user");
        return friendCircleService.deleteFriend(userId,friendId);

    }
}
