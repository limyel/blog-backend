package com.limyel.blog.common.enumerate;

public enum MemberStatus {

    NORMAL("正常"),
    UNACTIVE("未激活"),
    BAN("封禁"),
    FORBIDDEN("禁言")
    ;

    private String value;

    private MemberStatus(String value) {
        this.value = value;
    }

}
