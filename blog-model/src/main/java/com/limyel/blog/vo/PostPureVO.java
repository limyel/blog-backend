package com.limyel.blog.vo;

import com.limyel.blog.entity.Post;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PostPureVO {

    private String title;

    private String slug;

    private Date createTime;

    private List<TagPureVO> tagList;

    public PostPureVO(Post post) {
        BeanUtils.copyProperties(post, this);
    }

}
