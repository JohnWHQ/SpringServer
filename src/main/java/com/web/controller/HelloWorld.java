package com.web.controller;

import com.web.entity.Request;
import com.web.entity.Result;
import com.web.utils.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Controller示例
 */
@RestController
@RequestMapping(value = "/test")
public class HelloWorld {

    // test get
    @RequestMapping(value = "/hello/get",method = RequestMethod.GET)
    public Result<Object> helloGet(@RequestParam("token") String token,
                           @RequestParam(value="userId", required = false) String userId) {
        System.out.println("token  =" + token);
        System.out.println("userID =" + userId);

        Result<Object> res = new Result<>();
        res.setData("hello world! - from get");
        res.setSuccess();

        return res;
    }

    // test post
    @RequestMapping(value = "/hello/post",method = RequestMethod.POST)
    public Result helloPost(@RequestBody Request req) {
        System.out.print(req);

        Result res = new Result();
        res.setData("hello world! - from post");
        res.setSuccess();
        return res;
    }

    // test post
    @RequestMapping(value = "/token",method = RequestMethod.POST)
    public Result getToken(@RequestBody Request req) {

        Result res = new Result();
        res.setData(StringUtils.generateToken(req.getKey(), req.getValue()));
        res.setSuccess();
        return res;
    }
}
