<<<<<<< HEAD
package com.ysynzehao.spring.web.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ysynzehao.spring.base.entry.User;

@Component
public class UserServiceFeignClientFallback implements UserServiceFeignClient {
	
	@Override
	public List<User> getUserList() {
		return new ArrayList<>();
	}

	@Override
	public User saveUser(User user) {
		return new User();
	}

	@Override
	public User getUser(Long id) {
		System.out.println("-------------------------------getUser-------------------------------" + id);
		return new User();
=======
package com.ysynzehao.spring.provide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ysynzehao.spring.base.entry.User;
import com.ysynzehao.spring.dao.UserRepository;
import com.ysynzehao.spring.redis.service.JRedisService;

@Component
public class UserServiceFeignClientFallback implements UserServiceFeignClient {
	
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private JRedisService jRedisService;

	@Override
	public List<User> getUserList() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUser(long id) {
		 User user = jRedisService.get("user" + id, User.class);
		if (user == null) {
			System.out.println("--------------------------------------");
			user = userRepository.findOne(id);
			jRedisService.set("user" + id, user, 10);
		}
		return user;
>>>>>>> branch 'master' of https://github.com/ysynzehao/spring-cloud-demo.git
	}

}
