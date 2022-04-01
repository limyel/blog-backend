package com.limyel.blog.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentLatestVO {

    private Date createTime;

    private String content;

    private UserVO user;

    private PostInArchiveVO post;

}
