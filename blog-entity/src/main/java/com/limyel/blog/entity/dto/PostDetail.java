package com.limyel.blog.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PostDetail {

    private Long id;

    private Date createdAt;

    private List<TagInPost> tags;

    private Integer views;

    private String title;

    private String content;

}
