package com.ysynzehao.spring.provide;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RestController;

import com.ysynzehao.spring.base.entry.User;
import com.ysynzehao.spring.dao.UserRepository;
import com.ysynzehao.spring.redis.service.JRedisService;
import com.ysynzehao.spring.service.UserService;

/**
 * Created by Administrator on 2017/5/4.
 */
@RestController
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JRedisService jRedisService;

    @Cacheable(value = "usercache",keyGenerator = "wiselyKeyGenerator")
    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }
    
    @CachePut(value = "usercache",keyGenerator = "wiselyKeyGenerator")
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
