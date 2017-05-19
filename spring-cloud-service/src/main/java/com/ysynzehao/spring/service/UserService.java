package com.ysynzehao.spring.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ysynzehao.spring.base.entry.User;

/**
 * Created by Administrator on 2017/5/4.
 */
public interface UserService {

	@RequestMapping(value = "/getUserList", method = RequestMethod.GET, produces = "application/json")
    public List<User> getUserList();

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST, produces = "application/json")
    public User saveUser(User user);

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
    public User getUser(@PathVariable(value = "id") long id);
}
