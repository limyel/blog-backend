package com.limyel.blog.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User extends BaseEntity {

    private String username;

    private String avatarUrl;

    private String email;

    private String htmlUrl;

}