package com.neng.web.rest;

import com.neng.config.ApiConf;
import com.neng.pojo.config.Api;
import com.neng.pojo.enumClass.CustomServiceEnum;
import com.neng.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nengneng on 2017/6/15.
 */
@RestController
public class ShareController {

    private final static Logger log = LoggerFactory.getLogger(ShareController.class);


    @GetMapping(ApiConf.getMessage)
    public ResponseEntity<?> getMessage(@RequestParam("code") int code) {
        return choiceMessage(code);
    }

    private ResponseEntity<?> choiceMessage(int code) {
        Result<String> result=new Result<>();



        switch (code) {
            case 1:
                result.api(Api.SUCCESS);
                result.setData(CustomServiceEnum.ONE.getContent());
                return new ResponseEntity<>(result, HttpStatus.OK);
            case 2:
                result.api(Api.SUCCESS);
                result.setData(CustomServiceEnum.TWO.getContent());
                return new ResponseEntity<>(result, HttpStatus.OK);
            case 3:
                result.api(Api.SUCCESS);
                result.setData(CustomServiceEnum.THREE.getContent());
                return new ResponseEntity<>(result, HttpStatus.OK);
            default:
                System.out.println(code+ "1654564654");
                result.api(Api.PARMETER_NOT_EXIT);
                result.setData("not content");
                return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}

