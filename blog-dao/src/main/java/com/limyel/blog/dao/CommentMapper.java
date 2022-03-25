package com.limyel.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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

    List<CommentInPostVO> selectByPostId(Long postId);

    ParentCommentVO selectParentById(Long parentCommentId);

    List<Comment> selectLatest();

}