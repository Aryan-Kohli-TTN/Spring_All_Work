package com.example.Spring_Aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.example.Spring_Aop.Business.*.*(..))")

    // others are not working
    // myAnnotation not working check with mentors
//    @Before("execution(com.example.Spring_Aop.aspect.CommonJoinPointAspect.dataLayerExecution()")
    //    @Before("com.example.Spring_Aop.aspect.CommonJoinPointAspect.myAnnotationMethod()")
//    @Before("com.example.Spring_Aop.aspect.CommonJoinPointAspect.businessLayerExecution()")
    public void before(JoinPoint jp){
            logger.info("called before {}",jp);
    }
}
