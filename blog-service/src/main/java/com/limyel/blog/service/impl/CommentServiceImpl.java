package com.limyel.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.limyel.blog.core.util.PageUtil;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Override
    public int saveComment(Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public Comment getById(Long id) {
        return commentMapper.selectById(id);
    }

    @Override
    public PageUtil pageInPost(Post post, Long pageNum, Long pageSize) {
        IPage<Comment> page = new Page<>(pageNum, pageSize);

        return new PageUtil(commentMapper.selectByPostId(page, post.getId()));
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
