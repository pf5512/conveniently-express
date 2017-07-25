package com.neng.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 将异常映射为Http 状态码
 * Created by nengneng on 2017/7/12.
 */

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,
        reason = "UserInfoServiceImpl:用户注册向数据库插入数据时发生异常" )
public class UserNotFoundException extends RuntimeException {
}
