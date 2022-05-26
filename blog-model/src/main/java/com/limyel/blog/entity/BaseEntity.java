package com.limyel.blog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    @Id
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

}
