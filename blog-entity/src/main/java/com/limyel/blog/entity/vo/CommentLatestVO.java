package com.limyel.blog.entity.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentLatestVO {

    private Date createdAt;

    private String content;

    private UserVO user;

    private PostInArchiveVO post;

}
