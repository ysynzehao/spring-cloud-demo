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
		return new User();
	}

}
