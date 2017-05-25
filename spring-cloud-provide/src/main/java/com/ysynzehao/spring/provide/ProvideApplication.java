package com.ysynzehao.spring.provide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@EnableJpaRepositories("com.ysynzehao.spring.dao")
@EntityScan("com.ysynzehao.spring.base.entry")
@ComponentScan(basePackages={"com.ysynzehao.spring"})
public class ProvideApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvideApplication.class, args);
    }

}


