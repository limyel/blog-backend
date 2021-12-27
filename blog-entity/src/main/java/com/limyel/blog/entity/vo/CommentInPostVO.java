package com.limyel.blog.entity.vo;

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

    private Date createdAt;

    private String content;

    private MemberVO member;

    private ParentCommentVO parentComment;

    private Integer floor;

}
