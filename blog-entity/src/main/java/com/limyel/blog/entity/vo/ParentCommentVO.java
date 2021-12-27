package com.limyel.blog.entity.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ParentCommentVO {

    private Long id;

    private Date createdAt;

    private String content;

    private MemberVO member;

    private Integer floor;

}
