package com.limyel.blog.entity.dto;

import com.limyel.blog.entity.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PostInHome {

    private Long id;

    private Date createdAt;

    private Date updatedAt;

    private String title;

    private String introduction;

    private String slug;

    private List<TagInPost> tags;

}
