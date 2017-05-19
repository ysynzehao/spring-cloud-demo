package com.ysynzehao.spring.web.controller;

/**
 * Created by Administrator on 2017/5/3.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysynzehao.spring.service.UserService;

@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return "hello world";
    }
}
