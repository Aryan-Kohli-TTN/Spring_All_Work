package com.example.Spring_Aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
    private static Logger logger = LoggerFactory.getLogger(MethodExecutionCalculationAspect.class);

    @Around("execution(* com.example.Spring_Aop.Business.*.*(..))")
    public Object around(ProceedingJoinPoint jp) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object result = jp.proceed();
        long endTime = System.currentTimeMillis();
        long tt = endTime-startTime;
        logger.info("timre taken by  {} is {}",jp,tt);
        return result;
    }
}
