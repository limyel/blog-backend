package com.limyel.blog.dao;

import com.limyel.blog.entity.Comment;
import com.limyel.blog.entity.vo.CommentLatestVO;
import com.limyel.blog.entity.vo.CommentInPostVO;
import com.limyel.blog.entity.vo.ParentCommentVO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CommentMapper extends Mapper<Comment> {

    List<CommentInPostVO> selectByPostId(Long postId);

    ParentCommentVO selectParentById(Long parentCommentId);

    List<Comment> selectLatest();

}