package com.limyel.blog.dto;

import com.limyel.blog.entity.Tag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class TagDetailDTO {

    private String name;

    private String slug;

    private Integer postNum;

    public TagDetailDTO(Tag tag) {
        BeanUtils.copyProperties(tag, this);
    }

}
