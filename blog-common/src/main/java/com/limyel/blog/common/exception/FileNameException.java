package com.limyel.blog.common.exception;

import com.limyel.blog.common.enumeration.RetCode;

public class FileNameException extends BlogException {
    public FileNameException() {
        super(RetCode.INVALID_POSTDATA.getMsg(), RetCode.INVALID_POSTDATA.getCode());
    }
}