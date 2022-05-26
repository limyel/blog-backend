package com.limyel.blog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@Entity
public class User extends BaseEntity {

    private String username;

    private String avatarUrl;

    private String email;

    private String htmlUrl;

}