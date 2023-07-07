package com.tj.edu.practice4.aop.aops;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAop {
    @Pointcut("execution(* com.tj.edu.practice4.aop.controller..*.*(..)) ")
    private void logPointCut() {}

    @Before("logPointCut()")
    public void beforeLogAop(JoinPoint joinPoint) {
        System.out.println("LogAop의 before가 실행됨");
    }

    @After("logPointCut()")
    public void afterLogAop(JoinPoint joinPoint) {
        System.out.println("LogAop의 after가 실행됨");
    }
}
