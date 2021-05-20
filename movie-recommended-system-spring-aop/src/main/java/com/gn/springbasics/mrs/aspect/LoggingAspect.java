package com.gn.springbasics.mrs.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//@Aspect
@Configuration
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    //@AfterReturning("execution(* com.gn.springbasics.mrs.model.*.*(..))")
    @AfterReturning("com.gn.springbasics.mrs.configuration.JoinPointConfig.modelPointcut()")
    public void logAfterExecution(JoinPoint joinPoint) {
        logger.info("[UsingJoinPointConfig] Method {} complete", joinPoint);
    }

    @AfterReturning(
           // value = "execution(String com.gn.springbasics.mrs.model.*.*(..))",
            value = "com.gn.springbasics.mrs.configuration.JoinPointConfig.modelPointcut()",
            returning = "result"
    )
    public void logAfterExecutionWithReturn(JoinPoint joinPoint, Object result) {
        logger.info("[UsingJoinPointConfig] Method {} returned with {}", joinPoint, result);
    }

    @AfterThrowing(value = "execution(* com.gn.springbasics.mrs.model.*.*(..))",
            throwing = "exception")
    public void logAfterException(JoinPoint joinPoint, Object exception) {
        logger.info("Exception in {} returned with: {}", joinPoint, exception);
    }

    @After(value = "execution(* com.gn.springbasics.mrs.model.*.*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        logger.info("After {}", joinPoint);
    }
}
