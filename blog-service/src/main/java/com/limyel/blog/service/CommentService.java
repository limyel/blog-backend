package com.limyel.blog.service;

import com.github.pagehelper.PageInfo;
import com.limyel.blog.entity.Comment;
import com.limyel.blog.entity.Post;
import com.limyel.blog.entity.dto.CommentDTO;
import com.limyel.blog.entity.vo.CommentInPostVO;

import java.util.List;

/**
 * @author limyel
 */
public interface CommentService {

    int save(Comment comment);

    Comment getById(Long id);

    List<CommentInPostVO> pageInPost(Post post, int pageNum, int pageSize);

}
