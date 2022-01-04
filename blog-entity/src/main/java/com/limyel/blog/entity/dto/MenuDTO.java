package com.limyel.blog.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuDTO {

    private String name;

    private String path;

    private Integer sequence;

    private Long parentId;

}
