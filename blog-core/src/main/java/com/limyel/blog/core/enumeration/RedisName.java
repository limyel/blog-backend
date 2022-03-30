package com.limyel.blog.core.enumeration;

public enum RedisName {
    USER_ACTIVE("blog_user_active", "hash"),
    CAPTCHA("blog_captcha:", "string"),
    FORGET_PASSWORD("blog_forget_password:", "string")
    ;

    private String redisName;
    private String type;

    RedisName(String redisName, String type) {
        this.redisName = redisName;
        this.type = type;
    }

    public String getRedisName() {
        return this.redisName;
    }

    public String getType() {
        return this.type;
    }
}
