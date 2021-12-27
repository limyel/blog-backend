package com.limyel.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.limyel.blog.dao.CommentMapper;
import com.limyel.blog.entity.Comment;
import com.limyel.blog.entity.Post;
import com.limyel.blog.entity.dto.CommentDTO;
import com.limyel.blog.entity.vo.CommentInPostVO;
import com.limyel.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author limyel
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int save(Comment comment) {
        return commentMapper.insertSelective(comment);
    }

    @Override
    public Comment getById(Long id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CommentInPostVO> pageInPost(Post post, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return commentMapper.selectByPostId(post.getId());
    }
}
