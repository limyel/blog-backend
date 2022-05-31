package com.limyel.blog.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Where(clause = "where is_deleted = 0")
public class Tag extends BaseEntity {

    private String name;

    private String slug;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tagList")
    private List<Post> postList;

}