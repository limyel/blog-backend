package com.limyel.blog.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "post")
@Where(clause = "is_deleted = 0")
public class Post extends BaseEntity {

    public enum Type {
        post,
        about
    }

    private String title;

    private String content;

    private String slug;

    private Integer views;

    private Type type;

    @Column(name = "is_published", nullable = false)
    private Boolean published = false;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "post_tag",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private List<Tag> tagList;

}