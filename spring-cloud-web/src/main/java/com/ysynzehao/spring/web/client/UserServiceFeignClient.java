<<<<<<< HEAD
package com.ysynzehao.spring.web.client;
=======
package com.ysynzehao.spring.provide.service;
>>>>>>> branch 'master' of https://github.com/ysynzehao/spring-cloud-demo.git

import org.springframework.cloud.netflix.feign.FeignClient;

import com.ysynzehao.spring.service.UserService;

@FeignClient(value = "user-service", fallback = UserServiceFeignClientFallback.class)
public interface UserServiceFeignClient extends UserService {

}
