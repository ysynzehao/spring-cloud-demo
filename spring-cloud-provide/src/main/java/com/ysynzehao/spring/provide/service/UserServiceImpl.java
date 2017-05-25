package com.ysynzehao.spring.provide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ysynzehao.spring.base.entry.User;
import com.ysynzehao.spring.dao.UserRepository;
import com.ysynzehao.spring.redis.service.JRedisService;
import com.ysynzehao.spring.service.UserService;

@RestController
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private JRedisService jRedisService;

	@Override
	public List<User> getUserList() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUser(@PathVariable Long id) {
		 User user = jRedisService.get("user" + id.toString(), User.class);
		if (user == null) {
			System.out.println("------------------getUserFromDB--------------------");
			user = userRepository.findOne(id);
			if (user != null) {
				jRedisService.set("user" + id.toString(), user);
			}
		}
		return user;
	}

}
