package com.ysynzehao.spring.provide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ysynzehao.spring.provide.service.UserServiceFeignClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@EnableFeignClients(basePackageClasses = UserServiceFeignClient.class)
@ComponentScan(basePackageClasses = UserServiceFeignClient.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}


