package com.limyel.blog.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author limyel
 */
@Getter
@Setter
public class CommentInPostVO {

    private Long id;

    private Date createTime;

    private String content;

    private UserVO user;

    private ParentCommentVO parentComment;

    private Integer floor;

}
