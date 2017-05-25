package com.ysynzehao.spring.provide.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.ysynzehao.spring.service.UserService;

@FeignClient(value = "user-service", fallback = UserServiceFeignClientFallback.class)
public interface UserServiceFeignClient extends UserService {

}
