package com.limyel.blog.entity;

import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import javax.persistence.*;

@Getter
@Setter
@Table(name = "post")
public class Post {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private Date createdAt;

    private Date updatedAt;

    private Boolean deleted;

    private String title;

    private String content;

    private String slug;

    private String introduction;

    private Integer views;

}