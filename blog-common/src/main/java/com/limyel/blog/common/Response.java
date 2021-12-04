package com.limyel.blog.common;

import com.limyel.blog.common.enumerate.RetCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public Response() {

    }

    public Response(int code) {
        this.code = code;
    }

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public Response(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Response<T> success() {
        return new Response<T>(RetCode.SUCCESS.getCode(), RetCode.SUCCESS.getMsg());
    }

    public static <T> Response<T> success(T data) {
        return new Response<T>(RetCode.SUCCESS.getCode(), RetCode.SUCCESS.getMsg(), data);
    }

    public static <T> Response<T> success(String msg, T data) {
        return new Response<T>(RetCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> Response<T> successMsg(String msg) {
        return new Response<T>(RetCode.SUCCESS.getCode(), msg);
    }

    public static <T> Response<T> failed() {
        return new Response<T>(RetCode.FAILED.getCode(), RetCode.FAILED.getMsg());
    }

    public static <T> Response<T> failed(T data) {
        return new Response<T>(RetCode.FAILED.getCode(), RetCode.FAILED.getMsg(), data);
    }

    public static <T> Response<T> failed(String msg, T data) {
        return new Response<T>(RetCode.FAILED.getCode(), msg, data);
    }

    public static <T> Response<T> failedMsg(String msg) {
        return new Response<T>(RetCode.FAILED.getCode(), msg);
    }

    public static <T> Response<T> paramRequired() {
        return new Response<T>(RetCode.PARAM_REQUIRED.getCode(), RetCode.PARAM_REQUIRED.getMsg());
    }

    public static <T> Response<T> notFound() {
        return new Response<T>(RetCode.NOT_FOUND.getCode(), RetCode.NOT_FOUND.getMsg());
    }
}

