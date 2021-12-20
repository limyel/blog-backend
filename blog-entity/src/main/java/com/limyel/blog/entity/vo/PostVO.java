package com.limyel.blog.entity.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostVO {

    private String title;

    private String content;

    private String introduction;

    private List<Long> tags;

}
