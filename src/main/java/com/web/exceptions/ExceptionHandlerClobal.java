package com.web.exceptions;

import com.web.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常捕获类
 */

@ControllerAdvice
public class ExceptionHandlerClobal {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(ExceptionHandlerClobal.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<Object> exceptionHandle(Exception e) {
        Result<Object> res = new Result<>();

        if (e instanceof CommonException) {
            res.setFailed();
            res.setMsg(e.getMessage());
            return res;
        }

        res.setFailed();
        res.setMsg(e.toString());
        e.printStackTrace();
        logger.error("Exception-服务端未归类异常:{}", e.toString());
        return res;
    }


}
