package com.tj.edu.practice4.aop.aops;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// Spring Boot에서 AOP 설정
@Aspect
@Component
public class ParameterAop {

    // com.tj.edu.practice4.aop.controller 패키지에 있는 모든 컨트롤러에 진입했을 때 실행하라는 설정
    @Pointcut("execution(* com.tj.edu.practice4.aop.controller..*.*(..)) ")
    private void cut1() {}

    // com.tj.edu.practice4.aop.controller에서 실행되기 전에 실행하는 메소드
    @Before("cut1()")
    public void before(JoinPoint joinPoint) {
        System.out.println("aop의 before가 실행됨");
    }

    @AfterReturning(value = "cut1()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println("aop의 AfterReturning이 실행됨");
        System.out.println(returnObj);
    }

}