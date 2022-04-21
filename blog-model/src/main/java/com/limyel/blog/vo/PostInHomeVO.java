package com.limyel.blog.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PostInHomeVO {

    private Long id;

    private Date createTime;

    private Date updateTime;

    private String title;

    private String introduction;

    private String slug;

    private List<TagInPostVO> tags;

}
