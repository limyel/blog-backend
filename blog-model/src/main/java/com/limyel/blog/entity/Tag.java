package com.limyel.blog.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tag")
@Where(clause = "is_deleted = 0")
public class Tag extends BaseEntity {

    private String name;

    private String slug;

}