package com.limyel.blog.vo;

import com.limyel.blog.entity.Post;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PostDetailVO {

    private Long id;

    private Date createTime;

    private List<TagPureVO> tagList;

    private Integer views;

    private String title;

    private String content;

    public PostDetailVO(Post post) {
        BeanUtils.copyProperties(post, this);
        this.tagList = post.getTagList().stream().map(TagPureVO::new).collect(Collectors.toList());
    }

}
