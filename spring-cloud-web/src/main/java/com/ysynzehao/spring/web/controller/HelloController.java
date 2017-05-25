package com.ysynzehao.spring.web.controller;

/**
 * Created by Administrator on 2017/5/3.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysynzehao.spring.web.client.UserServiceFeignClient;

@RestController
public class HelloController {

    @Autowired
    private UserServiceFeignClient userService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return userService.getUser(1l).getName();
    }
}
