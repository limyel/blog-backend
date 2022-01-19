package com.limyel.blog.entity;

import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import javax.persistence.*;

@Getter
@Setter
@Table(name = "about_item")
public class AboutItem {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 是否删除
     */
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