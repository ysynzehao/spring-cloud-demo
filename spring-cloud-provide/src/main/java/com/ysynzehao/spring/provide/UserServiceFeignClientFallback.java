package com.ysynzehao.spring.provide;

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
	}

}
