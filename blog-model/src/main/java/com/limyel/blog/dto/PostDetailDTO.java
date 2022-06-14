package com.limyel.blog.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.limyel.blog.common.framework.LocalDateTimeToLongSerializer;
import com.limyel.blog.entity.Post;
import com.limyel.blog.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostDetailDTO {

    @JsonSerialize(using = LocalDateTimeToLongSerializer.class)
    private LocalDateTime createTime;

    private String title;

    private String slug;

    private Integer views;

    private String content;

    private List<Tag> tagList;

    public PostDetailDTO(Post post) {
        BeanUtils.copyProperties(post, this);
    }

}
