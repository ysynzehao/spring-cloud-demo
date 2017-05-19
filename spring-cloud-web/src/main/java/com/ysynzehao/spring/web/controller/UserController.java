package com.ysynzehao.spring.web.controller;

/**
 * Created by Administrator on 2017/5/3.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysynzehao.spring.base.entry.Result;
import com.ysynzehao.spring.base.entry.User;
import com.ysynzehao.spring.base.utils.ResultUtils;
import com.ysynzehao.spring.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public Result getUserList() {
        return ResultUtils.success(userService.getUserList());
    }
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public Result saveUser(User user) {
        return ResultUtils.success(userService.saveUser(user));
    }
    @PostMapping(value = "/getUser/{id}")
    public Result getUser(@PathVariable(value = "id") Long id) {
        return ResultUtils.success(userService.getUser(id));
    }
}
