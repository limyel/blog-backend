package com.limyel.blog.framework.advice;

import com.limyel.blog.common.Response;
import com.limyel.blog.common.enumerate.RetCode;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response error(Exception e) {
        e.printStackTrace();
        log.error("全局异常捕获: " + e);
        return Response.failed();
    }

    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseBody
    public Response expiredJwt(ExpiredJwtException e) {
        return new Response(RetCode.INVALID_TOKEN.getCode(), RetCode.INVALID_TOKEN.getMsg());
    }
}
