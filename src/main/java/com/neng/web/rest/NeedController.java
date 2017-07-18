package com.neng.web.rest;

import com.neng.config.ApiConf;
import com.neng.pojo.Need;
import com.neng.service.inner.NeedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 发布需求endpoints
 * Created by nengneng on 2017/6/7.
 */

@RestController
public class NeedController {


    private static final Logger logger = LoggerFactory.getLogger(NeedController.class);


    private NeedService needService;

    @Autowired
    public NeedController(NeedService needService) {
        this.needService = needService;
    }

    /**
     * 保存一个发布
     *
     * @param userId
     * @param need
     * @return
     */
    @PostMapping(value = ApiConf.saveNeed, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> saveNeed(Long userId, Need need) {
        logger.info("save need***************************");
        return needService.saveAndFlushNeed(userId, need);
    }


    /**
     * 获取所有的发布需求
     *
     * @return
     */
    @GetMapping(value = ApiConf.getNeeds, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getNeeds() {
        logger.info("get needs***************************");
        return needService.getNeeds();
    }

    /**
     * 获取用户发布的需求
     *
     * @param userId
     * @return
     */
    @GetMapping(value = ApiConf.getNeedsByUser, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getNeedsByUser(Long userId) {
        logger.info("get need by user***************************");
        return needService.getNeedsByUser(userId);
    }

    /**
     * 获取单个需求
     *
     * @param needId
     * @return
     */
    @GetMapping(value = ApiConf.getNeed, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getNeed(Long needId) {
        logger.info("get need by user***************************");
        return needService.getNeed(needId);
    }

    /**
     * 更新需求信息
     *
     * @param userId
     * @param needId
     * @param need
     * @return
     */
    @PutMapping(value = ApiConf.updateNeed, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateNeed(Long userId, Long needId, Need need) {
        logger.info("update need by user");
        return needService.updateNeed(userId, need, needId);

    }


    /**
     * 删除用户需求
     *
     * @param userId
     * @param needId
     * @return
     */
    @DeleteMapping(value = ApiConf.deleteNeed, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteNeed(Long userId, Long needId) {
        logger.info("delete need by user");
        return needService.deleteNeed(userId, needId);

    }

    @GetMapping(value = ApiConf.getWeiJieDan, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getWeiJieDan(@PathVariable("status") String status, Model model, HttpSession session) {
        List<Need> needs = needService.getWeiJieDan(status);
        model.addAttribute("needs", needs);
        return "";
    }
}
