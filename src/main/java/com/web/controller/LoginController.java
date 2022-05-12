package com.web.controller;

import com.web.cache.RedisUtils;
import com.web.dao.UserInfoDao;
import com.web.entity.Result;
import com.web.repository.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller示例
 */
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    UserInfoDao userInfoDao;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result userSave(@RequestBody UserInfo userInfo) {

        Result res = new Result();

        userInfo = userInfoDao.save(userInfo);
        redisUtils.setStr("redis_key", userInfo.toString(), 60 * 60 * 3);

        res.setData(userInfo);
        res.setMsg("user create success!");
        return res;
    }

}
