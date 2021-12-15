package com.limyel.blog.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagDetail {

    private Long id;

    private String name;

    private String slug;

    private Integer postNum;

}
