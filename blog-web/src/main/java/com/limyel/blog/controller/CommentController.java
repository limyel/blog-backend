package com.limyel.blog.controller;

import com.limyel.blog.common.Response;
import com.limyel.blog.entity.Post;
import com.limyel.blog.service.CommentService;
import com.limyel.blog.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Blog 评论")
@RestController
@RequestMapping("blog/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @ApiOperation(value = "列表", httpMethod = "GET")
    @GetMapping
    public Response list(
            @RequestParam(name = "postId", required = false) Long postId,
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize
    ) {
        Post post = postId == null? null: postService.getById(postId);
        if (postId != null && post == null) {
            return Response.notFound();
        }

        return null;
    }

}
