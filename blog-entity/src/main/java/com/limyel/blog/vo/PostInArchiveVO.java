package com.limyel.blog.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PostInArchiveVO {

    private Date createdAt;

    private String title;

    private String slug;

}
