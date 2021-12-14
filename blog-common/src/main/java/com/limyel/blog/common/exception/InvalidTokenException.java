package com.limyel.blog.common.exception;

import com.limyel.blog.common.enumerate.RetCode;

public class InvalidTokenException extends BlogException {
    public InvalidTokenException() {
        super(RetCode.INVALID_TOKEN.getMsg(), RetCode.INVALID_TOKEN.getCode());

    }
}
