package com.limyel.blog.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PostInArchive {

    private Date createdAt;

    private String title;

    private String slug;

}
