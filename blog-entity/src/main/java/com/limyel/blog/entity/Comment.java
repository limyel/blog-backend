package com.limyel.blog.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@TableName("comment")
public class Comment extends BaseEntity {

    private String content;

    private Long userId;

    private Long parentCommentId;

    private Long postId;

    private Integer floor;

    private Integer status;

}