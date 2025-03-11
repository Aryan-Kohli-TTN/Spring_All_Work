package com.example.Spring_Aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspect {

    private static Logger logger = LoggerFactory.getLogger(AfterAspect.class);

    // can be replaced with value="com.example.Spring_Aop.aspect.CommonJoinPointAspect.businessLayerExecution()"

    //    @AfterReturning(value="execution(* com.example.Spring_Aop.Business.*.*(..))", returning = "returnedValue")
    //    public void afterReturning(JoinPoint jp,Object returnedValue){
    //        logger.info("{} returned {}",jp,returnedValue);
    //    }
    //
//    @AfterThrowing(value="execution(* com.example.Spring_Aop.Business.*.*(..))",  throwing= "exception")
//    public void afterThrowing(JoinPoint jp,Object exception){
//        logger.info("{} throws {}",jp,exception);
//    }
//    @After(value="execution(* com.example.Spring_Aop.Business.*.*(..))")
        @After("com.example.Spring_Aop.aspect.CommonJoinPointAspect.businessLayerExecution()")

    public void after(JoinPoint jp){
//        logger.info("After called for {}",jp);
//        System.out.println("After called for "+jp);
        System.out.println("After");
    }
//    @After("com.example.Spring_Aop.aspect.CommonJoinPointAspect.myAnnotationMethod()")
//    public void after(JoinPoint jp){
//        logger.info("After called for {}",jp);
//    }
}
