package com.limyel.blog.service;

import com.limyel.blog.entity.Comment;
import com.limyel.blog.entity.Post;
import com.limyel.blog.entity.vo.CommentLatestVO;
import com.limyel.blog.entity.vo.CommentInPostVO;

import java.util.List;

/**
 * @author limyel
 */
public interface CommentService {

    /**
     * 保存
     * @param comment
     * @return
     */
    int save(Comment comment);

    /**
     * 通过 id 获取
     * @param id
     * @return
     */
    Comment getById(Long id);

    /**
     * 文章中的评论（分页）
     * @param post
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<CommentInPostVO> pageInPost(Post post, int pageNum, int pageSize);

    /**
     * 最新评论
     * @return
     */
    List<CommentLatestVO> listLatest();

}
