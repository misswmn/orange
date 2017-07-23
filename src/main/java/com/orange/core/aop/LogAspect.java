/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.orange.core.aop;

import com.orange.core.util.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/22
 * @description
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.orange.core.service.*.*(..))")
    private void monitor() {
    }

    @Pointcut("execution(* com.orange.core.controller.*.*(..))")
    private void controllerMonitor() {
    }

    @AfterThrowing(pointcut = "monitor()", throwing = "ex")
    private void beforeService(JoinPoint joinPoint, Exception ex) {
        print(joinPoint, ex);
    }

    @Around("controllerMonitor() && args(..,result)")
    public Object paramValid(ProceedingJoinPoint point, BindingResult result) throws Throwable {
        List<ObjectError> errors = result.getAllErrors();
        if (errors.size() > 0) {
            StringBuilder msg = new StringBuilder();
            for (ObjectError error : errors) {
                msg.append(error.getDefaultMessage());
                msg.append("\n");
            }
            return new HashMap<>();
        }
        System.out.println("after valid##################");
        return point.proceed();
    }

    private void print(JoinPoint joinPoint, Exception ex) {
        if (ex instanceof ConstraintViolationException) {
            ConstraintViolationException e = (ConstraintViolationException) ex;
            Set<ConstraintViolation<?>> errorSet = e.getConstraintViolations();
            List<String> errorList = errorSet.stream().map(exc -> exc.getMessage()).collect(Collectors.toList());
            throw new IllegalArgumentException(StringUtils.join(errorList, ","));
        } else {
            String name = joinPoint.getSignature().getDeclaringType().getSimpleName();
            String method = joinPoint.getSignature().getName();
            Object[] args = joinPoint.getArgs();
            String key = MessageFormat.format("{0}.{1} >>>>> {2}", name, method, JsonUtils.objectToJson(args));
            LOGGER.error(key, ex);
        }
    }
}
