package com.limyel.blog.core;

import com.limyel.blog.core.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public Response handleException(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return null;
    }

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public Response handleBlogException(HttpServletRequest request, BaseException baseException) {
        baseException.printStackTrace();
        return null;
    }

}
