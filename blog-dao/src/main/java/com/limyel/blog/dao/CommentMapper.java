package com.limyel.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.blog.entity.Comment;
import com.limyel.blog.vo.CommentInPostVO;
import com.limyel.blog.vo.ParentCommentVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author limyel
 */
@Repository
public interface CommentMapper extends BaseMapper<Comment> {

    IPage<CommentInPostVO> selectByPostId(IPage<Comment> page, Long postId);

    ParentCommentVO selectParentById(Long parentCommentId);

    List<Comment> selectLatest();

}