package com.tj.edu.practice4.aop.aops;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimeCheckerAop {
    @Pointcut("execution(* com.tj.edu.practice4.aop.controller..*.*(..)) ")
    private void cut1() {}
    @Pointcut("@annotation(com.tj.edu.practice4.aop.annotations.TimeChecker)")
    private void timeChecker1() {}
    @Before("cut1() && timeChecker1()")
    public void before(JoinPoint joinPoint) {
        System.out.println("TimeCheckerAop의 before가 실행됨");
    }
    @Around("cut1() && timeChecker1()")
    public Object around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // pointcut실행된 함수를 실행
        Object result = proceedingJoinPoint.proceed();

        stopWatch.stop();
        System.out.println("proceed리턴값: " + result);
        System.out.println("실행시간: " + stopWatch.getTotalTimeSeconds());

        return result;
    }
}
