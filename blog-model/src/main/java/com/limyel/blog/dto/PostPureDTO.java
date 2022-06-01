package com.limyel.blog.dto;

import com.limyel.blog.entity.Post;
import com.limyel.blog.entity.Tag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PostPureDTO {

    private Date createTime;

    private String title;

    private String slug;

    private List<Tag> tagList;

    public PostPureDTO(Post post) {
        BeanUtils.copyProperties(post, this);
    }

}
