package com.limyel.blog.entity.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author limyel
 */
@Getter
@Setter
public class CommentDTO {

    private String content;

    private Long parentId;

    private Long postId;

}
