package com.limyel.blog.vo;

import com.limyel.blog.entity.Tag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class TagDetailVO {

    private Long id;

    private String name;

    private String slug;

    private Integer postNum;

    public TagDetailVO(Tag tag) {
        BeanUtils.copyProperties(tag, this);
        this.postNum = tag.getPostList().size();
    }
}
