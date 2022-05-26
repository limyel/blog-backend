package com.limyel.blog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class PostTag extends BaseEntity {

    private Long postId;

    private Long tagId;

}