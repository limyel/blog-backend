package com.limyel.blog.entity;

import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import javax.persistence.*;

@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private Date createdAt;

    private Date updatedAt;

    private Boolean deleted;

    private String name;

    private String avatarUrl;

    private String email;

    private String htmlUrl;

}