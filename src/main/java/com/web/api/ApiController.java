package com.web.api;

import com.web.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by wanghanqi on 2019/11/11.
 */

@RestController
@RequestMapping(value = "api")
public class ApiController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(ApiController.class);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Result testApi() {
        Result res = new Result();
        res.setMsg("Api成功！");
        return res;

    }

}
