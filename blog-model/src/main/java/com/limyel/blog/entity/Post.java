package com.limyel.blog.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Where(clause = "is_deleted = 0")
public class Post extends BaseEntity {

    private String title;

    private String content;

    private String slug;

    private String introduction;

    private Integer views;

    private Boolean published;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tagList;

}