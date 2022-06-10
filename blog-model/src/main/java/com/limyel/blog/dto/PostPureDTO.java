package com.limyel.blog.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.limyel.blog.common.framework.LocalDateTimeToLongSerializer;
import com.limyel.blog.entity.Post;
import com.limyel.blog.entity.Tag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PostPureDTO {

    @JsonSerialize(using = LocalDateTimeToLongSerializer.class)
    private LocalDateTime createTime;

    private String title;

    private String slug;

    private List<Tag> tagList;

    public PostPureDTO(Post post) {
        BeanUtils.copyProperties(post, this);
    }

}
