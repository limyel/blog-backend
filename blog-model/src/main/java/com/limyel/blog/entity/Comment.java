package com.limyel.blog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@Entity
public class Comment extends BaseEntity {

    private String content;

    private Long userId;

    private Long postId;

    private Integer floor;

    private Boolean published;

}