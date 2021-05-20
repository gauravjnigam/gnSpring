package com.gn.springbasics.mrs.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AccessCheckAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //@Before("execution(* com.gn.springbasics.mrs.service.*.*(..))")
    //@Before("execution(String com.gn.springbasics.mrs.service.*.*(..))")
    //@Before("execution(* com.gn.springbasics.mrs.service.*.*Filtering(..))")
    //@Before("execution(* com.gn.springbasics.mrs.service.*.*(String,..))")
    //@Before("execution(* com.gn.springbasics.mrs.service.*.*(String))")
    //@Before("execution(* com.gn.springbasics.mrs.service.*.*(String)) || execution(* com.gn.springbasics.mrs.service.*.*Filtering(..))")
    @Before("com.gn.springbasics.mrs.configuration.JoinPointConfig.allLayersPointcut()")
    public void before(JoinPoint joinPoint) {
        logger.info("[UsingJoinPointConfig] Intercepted call before execution of: {}", joinPoint);
    }

}
