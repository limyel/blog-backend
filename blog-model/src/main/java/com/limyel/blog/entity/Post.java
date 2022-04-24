package com.limyel.blog.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post extends BaseEntity {

    public enum Type {
        blog,
        weekly,
        about,
        profile,
    }

    private String title;

    private String content;

    private String slug;

    private String introduction;

    private Integer views;

    @EnumValue
    private Type type;

    @TableField(value = "is_published")
    private Boolean published;

}