package com.limyel.blog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post extends BaseEntity {

    private String title;

    private String content;

    private String slug;

    private Integer views;

    @Column(name = "is_published", nullable = false)
    private Boolean published = false;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "post_tag",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private List<Tag> tagList;

}