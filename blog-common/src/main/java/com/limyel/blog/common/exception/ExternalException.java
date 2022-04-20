package com.limyel.blog.common.exception;

import com.limyel.blog.common.enumeration.RetCode;

public class ExternalException extends BlogException {
    public ExternalException() {
        super(RetCode.EXTERNAL_FAILURE.getMsg(), RetCode.EXTERNAL_FAILURE.getCode());
    }
}
