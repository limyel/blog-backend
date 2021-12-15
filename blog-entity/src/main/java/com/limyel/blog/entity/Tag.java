package com.limyel.blog.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;

@Getter
@Setter
@Table(name = "tag")
public class Tag {
    private Long id;

    private Date createdAt;

    private Date updatedAt;

    private Boolean deleted;

    private String name;

    private String slug;
}