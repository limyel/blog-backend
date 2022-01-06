package com.limyel.blog.entity.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PostDetailVO {

    private Long id;

    private Date createdAt;

    private List<TagInPostVO> tags;

    private Integer views;

    private String title;

    private String introduction;

    private String content;

}
