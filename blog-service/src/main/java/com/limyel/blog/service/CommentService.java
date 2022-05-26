package com.limyel.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.limyel.blog.common.utils.PageUtil;
import com.limyel.blog.entity.Comment;
import com.limyel.blog.entity.Post;
import com.limyel.blog.vo.CommentLatestVO;

import java.util.List;

/**
 * @author limyel
 */
public interface CommentService extends IService<Comment> {

    /**
     * 保存
     * @param comment
     * @return
     */
    void saveComment(Comment comment);

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
    PageUtil pageInPost(Post post, Long pageNum, Long pageSize);

    /**
     * 最新评论
     * @return
     */
    List<CommentLatestVO> listLatest();

}
