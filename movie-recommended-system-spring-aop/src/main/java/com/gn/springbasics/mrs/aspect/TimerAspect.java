package com.gn.springbasics.mrs.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

//@Aspect
@Configuration
public class TimerAspect {

    public static final Logger logger = LoggerFactory.getLogger(TimerAspect.class);

    @Around("execution(* com.gn.springbasics.mrs.service.*.*(..))")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) {
        StopWatch stopWatch = new StopWatch();
        Object returnValue = null;
        try {
            stopWatch.start();
            returnValue = joinPoint.proceed();
            stopWatch.stop();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        logger.info("Time taken by {} to complete is : {}", joinPoint, stopWatch.getTotalTimeMillis());
        return returnValue;

    }
}
