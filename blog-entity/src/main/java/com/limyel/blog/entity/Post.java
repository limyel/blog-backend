package com.limyel.blog.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.blog.utils.SlugUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

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