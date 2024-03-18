package com.assessment.photographer.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

  @Before("execution(* com.assessment.photographer.service..*.*(..))")
  public void logBefore(JoinPoint joinPoint) {
    log.info("Entering method: {}.{}() with arguments: {}", joinPoint.getSignature().getDeclaringTypeName(),
        joinPoint.getSignature().getName(), joinPoint.getArgs());
  }

  @After("execution(* com.assessment.photographer.service..*.*(..))")
  public void logAfter(JoinPoint joinPoint) {
    log.info("Exiting method: {}.{}()", joinPoint.getSignature().getDeclaringTypeName(),
        joinPoint.getSignature().getName());
  }

  @Around("execution(* com.assessment.photographer.service..*.*(..))")
  public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    Object proceed = joinPoint.proceed();
    long executionTime = System.currentTimeMillis() - start;
    log.info("Method {} executed in {} ms", joinPoint.getSignature().getName(), executionTime);
    return proceed;
  }
}


