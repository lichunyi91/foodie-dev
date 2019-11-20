package com.imooc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceLogAspect {

    public static  final Logger LOGGER=LoggerFactory.getLogger(ServiceLogAspect.class);
    @Around("execution(* com.imooc.service.impl..*.*(..))")
    public  Object  recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("====== 开始执行 {}.{} ======",
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature().getName());

        long  begin =System.currentTimeMillis();
        Object result =joinPoint.proceed();
        long  end =System.currentTimeMillis();
        long takeTime = end - begin;

        if(takeTime>3000){
            LOGGER.error("====== 执行结束，耗时：{} 毫秒 ======", takeTime);
        }else if(takeTime>2000){
            LOGGER.warn("====== 执行结束，耗时：{} 毫秒 ======", takeTime);
        }else{
            LOGGER.info("====== 执行结束，耗时：{} 毫秒 ======", takeTime);
        }
        return result;
    }


}
