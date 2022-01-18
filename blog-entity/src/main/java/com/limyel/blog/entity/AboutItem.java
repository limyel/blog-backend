package com.limyel.blog.entity;

import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import javax.persistence.*;

@Table(name = "about_item")
public class AboutItem {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    // 创建时间
    private Date createdAt;

    // 更新时间
    private Date updatedAt;

    // 是否删除
    private Boolean deleted;

    // 项目名
    private String name;

    // 链接
    private String link;

    // 描述
    private String description;

    private Long aboutId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getAboutId() {
        return aboutId;
    }

    public void setAboutId(Long aboutId) {
        this.aboutId = aboutId;
    }
}