package com.limyel.blog.dao;

import com.limyel.blog.entity.Comment;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CommentMapper extends Mapper<Comment> {
}