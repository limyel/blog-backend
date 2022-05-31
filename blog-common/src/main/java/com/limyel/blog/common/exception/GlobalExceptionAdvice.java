package com.limyel.blog.common.exception;

import com.limyel.blog.common.api.Response;
import com.limyel.blog.common.config.ExceptionCodeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionAdvice {

    @Autowired
    private ExceptionCodeConfig exceptionCodeConfig;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<String> handleException(HttpServletRequest request, Exception e) {
        log.error(e.getMessage());
        String url = request.getRequestURI();
        String method = request.getMethod();
        return Response.failed(method + " " + url);
    }

    @ExceptionHandler(value = ApiException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Response<String> handleApiException(HttpServletRequest request, ApiException e) {
        String msg = exceptionCodeConfig.getMessage(e.getCode());
        log.error(msg);
        return new Response<>(e.getCode(), msg, this.formatExceptionData(request));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public Response<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder("校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(", ");
        }
        String msg = sb.toString();
        return Response.failed(msg);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseBody
    public Response<String> handleConstraintViolationException(ConstraintViolationException ex) {
        return Response.failed(ex.getMessage());
    }

    private String formatExceptionData(HttpServletRequest request) {
        return request.getMethod() + " " + request.getRequestURI();
    }
}
