package com.limyel.blog.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostDTO {

    private String title;

    private String content;

    private String introduction;

    private List<Long> tags;

}
