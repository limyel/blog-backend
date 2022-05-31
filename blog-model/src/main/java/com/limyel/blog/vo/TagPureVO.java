package com.limyel.blog.vo;

import com.limyel.blog.entity.Tag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class TagPureVO {

    private Long id;

    private String name;

    private String slug;

    public TagPureVO(Tag tag) {
        BeanUtils.copyProperties(tag, this);
    }
}
