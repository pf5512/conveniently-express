package com.neng.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理
 * @ControllerAdvice 会包含了一个或者多个如下类型的方法：@ExceptionHandler @InitBinder @ModelAttribute
 * 将所有的@ExceptionHandler方法收集到一个类中，这样所有控制器的异常就能同意来处理
 * Created by nengneng on 2017/7/12.
 */
@ControllerAdvice
public class WebAppException {

    private static final Logger log = LoggerFactory.getLogger(WebAppException.class);


    /**
     * 可以直接返回视图
     * @return
     */
    @ExceptionHandler(UserUpdateException.class)
    public void userUpdateFail(){
        log.info("数据库更新失败");
    }




}
