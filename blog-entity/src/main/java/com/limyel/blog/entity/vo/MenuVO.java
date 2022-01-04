package com.limyel.blog.entity.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MenuVO {

    private Long id;

    private String name;

    private String path;

    private Integer sequence;

    private List<MenuVO> subMenus;

}
