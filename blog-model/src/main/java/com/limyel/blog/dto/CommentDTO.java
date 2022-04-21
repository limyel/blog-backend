package com.limyel.blog.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author limyel
 */
@Getter
@Setter
public class CommentDTO {

    private String content;

    private Long postId;

}
