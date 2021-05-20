package com.gn.springbasics.mrs.configuration;

import org.aspectj.lang.annotation.Pointcut;

public class JoinPointConfig {

    @Pointcut("execution(* com.gn.springbasics.mrs.model.*.*(..))")
    public void modelLayerPointcut() {}

    @Pointcut("execution(* com.gn.springbasics.mrs.service.*.*(..))")
    public void serviceLayerPointcut() {}

    @Pointcut("com.gn.springbasics.mrs.configuration.JoinPointConfig.modelLayerPointcut() || "
            + "com.gn.springbasics.mrs.configuration.JoinPointConfig.serviceLayerPointcut()")
    public void allLayersPointcut() {}

    //for a particular bean
    @Pointcut("bean(movie*)")
    public void movieBeanPointcut() {}
}
