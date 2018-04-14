package com.epam.labs.lab5.aop;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Log4j2
@Aspect
@Component
public class MethodTimerLoggerAspect {

    @SneakyThrows
    @Around("@annotation(Profile)")
    public Object logTime(ProceedingJoinPoint proceedingJoinPoint) {
        long startTime = System.currentTimeMillis();

        Object proceed = proceedingJoinPoint.proceed();

        long workTime = System.currentTimeMillis() - startTime;

        log.info(String.format("%s worked %d", proceedingJoinPoint.getSignature().toString(), workTime));
        return proceed;
    }
}
