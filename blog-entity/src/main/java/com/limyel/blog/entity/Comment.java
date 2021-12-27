package com.limyel.blog.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;

@Getter
@Setter
@Table(name = "comment")
public class Comment {
    private Long id;

    private Date createdAt;

    private Date updatedAt;

    private Boolean deleted;

    private String content;

    private Long memberId;

    private Long parentCommentId;

    private Long postId;

    private Integer floor;

    private Integer status;

}