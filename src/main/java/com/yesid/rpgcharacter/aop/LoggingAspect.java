package com.yesid.rpgcharacter.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.yesid.rpgcharacter.adapter.inbound.controller..*) " +
            "|| within(com.yesid.rpgcharacter.domain.usecase..*) " +
            "|| within(com.yesid.rpgcharacter.adapter.outbound.persistence..*)")
    public void applicationPackagePointCut(){}

    @Around("applicationPackagePointCut()")
    public Object logRequests(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        Map<String, Object> arguments = new HashMap<>(methodSignature.getParameterNames().length);
        for (int i = 0; i < methodSignature.getParameterNames().length; i++) {
            arguments.put(methodSignature.getParameterNames()[i], joinPoint.getArgs()[i]);
        }

        logger.info("Enter: {}.{}() with argument[s] = {}", className, methodName, arguments);
        try {
            Object result = joinPoint.proceed();
            logger.info("Exit: {}.{}() with result = {}", className, methodName, result);
            return result;
        } catch (Throwable e) {
            logger.error("", e);
            throw e;
        }
    }
}
