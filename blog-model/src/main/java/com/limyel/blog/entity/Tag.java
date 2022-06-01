package com.limyel.blog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tag")
public class Tag extends BaseEntity {

    private String name;

    private String slug;

}