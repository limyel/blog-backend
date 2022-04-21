package com.limyel.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.Date;

@Getter
@Setter
public class Comment extends BaseEntity {

    private String content;

    private Long userId;

    private Long postId;

    private Integer floor;

    @TableField(value = "is_published")
    private Boolean published;

}