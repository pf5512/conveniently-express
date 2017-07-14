package com.neng.web.rest;

import com.neng.config.ApiConf;
import com.neng.pojo.AlwaysLocation;
import com.neng.pojo.FriendCircle;
import com.neng.service.inner.AlwaysLocationService;
import com.neng.service.inner.FriendCircleService;
import com.neng.service.inner.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by nengneng on 2017/7/14.
 */
@RestController
public class AddressController {

    private static final Logger logger= LoggerFactory.getLogger(AddressController.class);

    private AlwaysLocationService alwaysLocationService;

    private UserService userService;

    @Autowired
    public AddressController(AlwaysLocationService alwaysLocationService,
                             UserService userService) {
        this.alwaysLocationService = alwaysLocationService;
        this.userService = userService;
    }


    /**
     * 保存一个地址
     * @param userId
     * @param alwaysLocation
     * @return
     */
    @PostMapping(value = ApiConf.saveHomeAddress,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> saveFriend(Long userId, AlwaysLocation alwaysLocation){
        logger.info("save address***************************");
        return alwaysLocationService.save(userId,alwaysLocation);
    }

    /**
     * 获取所有的地址
     * @return
     */
    @GetMapping(value = ApiConf.getHomeAddresses,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getAddresses(Long userId){
        logger.info("get addresses***************************");
        return alwaysLocationService.getHomeAddresses(userId);
    }

    /**
     * 修改一个地址
     * @param userId
     * @param alwaysLocation
     * @return
     */
    @PutMapping(value = ApiConf.updateHomeAddress,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> updateHomeAddress(Long userId, AlwaysLocation alwaysLocation){
        logger.info("save updateHomeAddress***************************");
        return alwaysLocationService.updateHomeAddress(userId,alwaysLocation);
    }






    /**
     * 删除地址
     * @param userId
     * @param addressId
     * @return
     */
    @DeleteMapping(value = ApiConf.deleteHomeAddress,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteFriend(Long userId, Long addressId) {
        logger.info("delete address by user");
        return alwaysLocationService.deleteAAddress(userId,addressId);

    }
}
