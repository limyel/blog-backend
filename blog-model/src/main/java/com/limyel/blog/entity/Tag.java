package com.limyel.blog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@Entity
public class Tag extends BaseEntity {

    private String name;

    private String slug;

}