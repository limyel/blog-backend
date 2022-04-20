package com.limyel.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.common.util.SlugUtil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("post")
public class Post extends BaseEntity {

    private String title;

    private String content;

    private String slug;

    private String introduction;

    private Integer views;

    public void setTitle(String title) {
        this.title = title;
        this.slug = SlugUtil.generate(title);
    }

}