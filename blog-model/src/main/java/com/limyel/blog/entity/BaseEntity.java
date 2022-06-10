package com.limyel.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    private LocalDateTime createTime;

    @JsonIgnore
    private LocalDateTime updateTime;

    @JsonIgnore
    @Column(name = "is_deleted")
    private Boolean deleted;

}
