package com.example.Spring_Aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CommonJoinPointAspect {
    @Pointcut("execution(* com.example.Spring_Aop.Data.*.*(..))")
    public void dataLayerExecution(){}
    @Pointcut("execution(* com.example.Spring_Aop.Business.*.*(..))")
    public void businessLayerExecution(){}
    @Pointcut("execution(* com.example.Spring_Aop.Business.*.*(..)) && execution(* com.example.Spring_Aop.Business.*.*(..))")
    public void businessAndDataLayerExecution(){}

    @Pointcut("bean(Dao*)")
    public void startsWithDao(){}

    @Pointcut("within(* com.example.Spring_Aop.Data..*")
    public void dataWithinLayerExecution(){}

    @Pointcut("@annotation(com.example.Spring_Aop.Annotations.MyAnnotation)")
    public void myAnnotationMethod(){}

}
