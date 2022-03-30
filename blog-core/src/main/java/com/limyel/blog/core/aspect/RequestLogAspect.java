package com.limyel.blog.core.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.UUID;

@Component
@Aspect
@Slf4j
public class RequestLogAspect {

    // 记录请求花费的时间
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.limyel.blog.controller.*.*(..))")
    public void requestLog(){}

    /**
     * 请求日志
     * @param joinPoint
     */
    @Before(value = "requestLog()")
    public void doBefore(JoinPoint joinPoint) {
        MDC.put("LOG_ID", UUID.randomUUID().toString());

        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 相应日志
     * @param result
     */
    @AfterReturning(returning = "result", pointcut = "requestLog()")
    public void doAfterReturning(Object result) {
        log.info("RESPONSE : " + result);
        log.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }

    @AfterThrowing(throwing = "e", pointcut = "requestLog()")
    public void doAftgerThrowing(JoinPoint joinPoint, Exception e) {
        log.error(joinPoint.getSignature().getName() + "EXCEPTION : " + e.getMessage());
    }

    @Around("requestLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        Long startTime = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error("EXCEPTION : " + e);
        }
        long endTime = System.currentTimeMillis();
        log.info("EXECUTE TIME : " + (endTime - startTime));
        return result;
    }

}
