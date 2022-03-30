package com.limyel.blog.common.exception;

/**
 * 如果继承 Exception，必须手动处理异常，捕获或者抛出，而如果继承 RuntimeException，则可以交给框架来处理该异常
 */
public class BlogException extends RuntimeException {

    private String msg;

    private int code = 500;

    public BlogException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BlogException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BlogException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BlogException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }


}
