package com.web.controller;

import com.web.entity.Request;
import com.web.entity.Result;
import com.web.utils.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by wanghanqi on 2019/10/23.
 */
@RestController
@RequestMapping(value = "/test")
public class HelloWorld {

    public static void main(String[] args) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {1, 2});
        Arrays.fill(new int[2], -1);
        String s = "";
        ArrayList<String> l = new ArrayList<>();
        Collections.sort(l, (o1, o2) -> {
            String[] cur1 = o1.split(" ", 2);
            String[] cur2 = o2.split(" ", 2);
            if(cur1[1].equals(cur2[1])) {
                return cur1[0].compareTo(cur2[0]);
            } else {
                return cur1[1].compareTo(cur2[1]);
            }
        });

    }

    // test get
    @RequestMapping(value = "/hello/get",method = RequestMethod.GET)
    public Result helloGet(@RequestParam("token") String token,
                           @RequestParam(value="userId", required = false) String userId) {
        System.out.println("token  =" + token);
        System.out.println("userID =" + userId);

        Result res = new Result();
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
