// Copyright 2018 Baidu Inc BDG. All rights reserved.

package com.web.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 *  拦截器示例 登录拦截器
 */
@Aspect
@Component
public class LogControllerAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogControllerAspect.class);

    // 切入点定义 拦截controller
    @Pointcut("execution(public * com.web.controller..*(..))) ")
    public void log() {
        // to-do
    }

    // 前切
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {

        String info = "[服务处理开始]-\n[request_info]:\n";

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest servletRequest = attributes.getRequest();

        info = info + "url          = " + servletRequest.getRequestURL() + "\n";
        info = info + "method       = " + servletRequest.getMethod() + "\n";
        info = info + "ip           = " + servletRequest.getRemoteAddr() + "\n";
        info = info + "class_method = " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName() + "\n";
        info = info + "arg_name     = " + Arrays.asList(((MethodSignature)joinPoint.getSignature()).getParameterNames()) + "\n";
        info = info + "arg          = " + JSON.toJSONString(joinPoint.getArgs()) + "\n";

        logger.info(info);
    }

    // 后切
    @After("log()")
    public void doAfter() {
        // to-do
    }

    // 返回值拦截
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        if (object == null) {
            logger.info("[服务处理结束]-\n[response_info]:\nresponse={}", "object is null");
        } else {
            logger.info("[服务处理结束]-\n[response_info]:\nresponse={}", object.toString());
        }
    }
}
