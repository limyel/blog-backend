package com.limyel.blog.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Tag extends BaseEntity {

    private String name;

    private String slug;

}