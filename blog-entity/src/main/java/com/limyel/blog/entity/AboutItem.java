package com.limyel.blog.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@TableName("about_item")
public class AboutItem {

    @TableId
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    /**
     * 项目名
     */
    private String name;

    /**
     * 链接
     */
    private String link;

    /**
     * 描述
     */
    private String description;

    /**
     * about id
     */
    private Long aboutId;

    /**
     * 顺序
     */
    private Integer sequence;

}