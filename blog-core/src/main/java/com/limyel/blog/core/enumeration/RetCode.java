package com.limyel.blog.core.enumeration;

/**
 * 响应状态码
 */
public enum RetCode {
    SUCCESS(0, "成功", "success"),

    EXTERNAL_FAILURE(-260, "第三方服务错误", "external failure"),

    // 操作
    FAILED(-250, "失败", "failed"),
    TIMEOUT(-251, "超时", "timeout"),
    UNKNOWN(-252, "未知错误", "unknown"),
    TOO_FREQUENT(-253, "请求过于频繁", "request too frequent"),
    DEPRECATED(-254, "已废弃", "interface deprecated"),

    // 资源
    NOT_FOUND(-240, "未找到", "not found"),
    ALREADY_EXISTS(-241, "已存在", "already exists"),

    // 权限
    PERMISSION_DENIED(-230, "无权访问", "permission denied"),
    INVALID_ROLE(-231, "无法获得此权限角色", "acquire role failed"),
    INVALID_TOKEN(-232, "无效token", "invalid access token"),

    // 请求内容
    INVALID_PARAMS(-220, "非法参数", "invalid parameters"),
    INVALID_POSTDATA(-221, "非法提交内容", "invalid post"),

    // HTTP请求异常
    INVALID_HEADERS(-210, "非法请求头", "invalid headers"),

    SERVER_ERROR(-200, "服务器内部错误", "server error"),

    WS_DONE(10, "Websocket 请求完成", "websocket request done"),

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
