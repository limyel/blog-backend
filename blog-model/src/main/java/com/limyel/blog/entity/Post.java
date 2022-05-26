package com.limyel.blog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
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

    private Type type;

    private Boolean published;

}