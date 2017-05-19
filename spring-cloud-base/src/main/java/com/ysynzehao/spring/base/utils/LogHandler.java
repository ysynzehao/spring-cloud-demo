package com.ysynzehao.spring.base.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/4.
 */
@Aspect
@Component
public class LogHandler {

    private Logger logger = LoggerFactory.getLogger(LogHandler.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @Pointcut(value = "execution(* com.ysynzehao.service.*.*(..))")
    public void common(){}

    @Before("common()")
    public void before(JoinPoint joinPoint) {

        logger.info("before: class.method: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

    @After("common()")
    public void after(JoinPoint joinPoint) {

        logger.info("after: class.method: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

    @AfterReturning(returning = "object", pointcut="common()")
    public void returnMsg(JoinPoint joinPoint, Object object) {
        try {
            logger.info("returnMsg: " + objectMapper.writeValueAsString(object));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
