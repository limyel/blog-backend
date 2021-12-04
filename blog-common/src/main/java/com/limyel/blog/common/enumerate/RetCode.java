package com.limyel.blog.common.enumerate;

/**
 * 响应状态码
 */
public enum RetCode {
    SUCCESS(0, "成功", "success"),

    EXTERNAL_FAILURE(-269, "第三方服务错误", "external failure"),

    FAILED(-255, "失败", "failed"),
    TIMEOUT(-254, "超时", "timeout"),
    UNKNOWN(-253, "未知错误", "unknown"),
    TOO_FREQUENT(-252, "请求过于频繁", "request too frequent"),
    DEPRECATED(-251, "已废弃", "interface deprecated"),

    NOT_FOUND(-249, "未找到", "not found"),
    ALREADY_EXISTS(-248, "已存在", "already exists"),

    PERMISSION_DENIED(-239, "无权访问", "permission denied"),
    INVALID_ROLE(-238, "无法获得此权限角色", "acquire role failed"),
    INVALID_TOKEN(-237, "无效token", "invalid access token"),

    CHECK_FAILURE(-229, "校验失败", "check failure"),
    PARAM_REQUIRED(-228, "需要参数", "parameter(s) required"),
    POSTDATA_REQUIRED(-227, "需要请求体参数", "post data item(s) required"),

    INVALID_PARAMS(-219, "非法参数", "invalid parameters"),
    INVALID_POSTDATA(-218, "非法提交内容", "invalid post"),
    INVALID_HEADERS(-217, "非法请求头", "invalid headers"),

    WS_DONE(1, "Websocket 请求完成", "websocket request done"),

    ;

    private Integer code;
    private String msg;
    private String msgEN;

    RetCode(Integer code, String msg, String msgEN) {
        this.code = code;
        this.msg = msg;
        this.msgEN = msgEN;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsgEN() {
        return msgEN;
    }

    public void setMsgEN(String msgEN) {
        this.msgEN = msgEN;
    }
}
