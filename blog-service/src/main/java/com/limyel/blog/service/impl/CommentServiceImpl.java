package com.limyel.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.limyel.blog.dao.CommentMapper;
import com.limyel.blog.entity.Comment;
import com.limyel.blog.entity.Post;
import com.limyel.blog.vo.CommentLatestVO;
import com.limyel.blog.vo.CommentInPostVO;
import com.limyel.blog.vo.PostInArchiveVO;
import com.limyel.blog.vo.UserVO;
import com.limyel.blog.service.CommentService;
import com.limyel.blog.service.PostService;
import com.limyel.blog.service.UserService;
import com.limyel.blog.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author limyel
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

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

    @Override
    public List<CommentLatestVO> listLatest() {
        List<Comment> comments = commentMapper.selectLatest();
        List<CommentLatestVO> result = new ArrayList<>();
        comments.forEach(comment -> {
            CommentLatestVO commentLatestVO = BeanUtil.copy(comment, CommentLatestVO.class);
            commentLatestVO.setUser(BeanUtil.copy(userService.getById(comment.getUserId()), UserVO.class));
            commentLatestVO.setPost(BeanUtil.copy(postService.getById(comment.getPostId()), PostInArchiveVO.class));
            result.add(commentLatestVO);
        });
        return result;
    }
}
