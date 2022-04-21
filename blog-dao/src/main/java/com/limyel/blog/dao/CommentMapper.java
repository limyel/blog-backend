package com.limyel.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.entity.Comment;
import com.limyel.blog.vo.CommentInPostVO;
import com.limyel.blog.vo.ParentCommentVO;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper extends BaseMapper<Comment> {

    Page<CommentInPostVO> selectByPostId(Page<CommentInPostVO> page, Long postId);


}