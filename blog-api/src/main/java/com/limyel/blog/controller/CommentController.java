package com.limyel.blog.controller;

import com.limyel.blog.core.Response;
import com.limyel.blog.core.annotation.CurrentUser;
import com.limyel.blog.core.util.PageUtil;
import com.limyel.blog.entity.Comment;
import com.limyel.blog.entity.User;
import com.limyel.blog.entity.Post;
import com.limyel.blog.dto.CommentDTO;
import com.limyel.blog.vo.CommentInPostVO;
import com.limyel.blog.vo.CommentLatestVO;
import com.limyel.blog.service.CommentService;
import com.limyel.blog.service.PostService;
import com.limyel.blog.utils.BeanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Blog 评论")
@RestController
@RequestMapping("blog/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @ApiOperation(value = "文章中的列表", httpMethod = "GET")
    @GetMapping("/post/{id}")
    public Response<PageUtil> listInPost(
            @PathVariable(name = "id") Long id,
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Long pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Long pageSize
    ) {
        Post post = postService.getById(id);
        if (post == null) {
            return Response.notFound();
        }

        PageUtil pageUtil = commentService.pageInPost(post, pageNum, pageSize);

        return Response.success(pageUtil);
    }

    @ApiOperation(value = "发布", httpMethod = "POST")
    @PostMapping
    public Response save(
            @CurrentUser User user,
            @RequestBody CommentDTO commentDTO
    ) {
        Comment comment = BeanUtil.copy(commentDTO, Comment.class);
        if (comment.getParentCommentId() != null && commentService.getById(comment.getParentCommentId()) == null) {
            return Response.notFound();
        }
        if (comment.getPostId() != null && postService.getById(comment.getPostId()) == null) {
            return Response.notFound();
        }
        comment.setUserId(user.getId());

        commentService.save(comment);

        return Response.success();
    }

    @ApiOperation(value = "最新", httpMethod = "GET")
    @GetMapping("/latest")
    public Response latest() {
        List<CommentLatestVO> result = commentService.listLatest();
        return Response.success(result);
    }

}
