package com.limyel.blog.admin;

import com.limyel.blog.service.CommentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Admin 评论")
@RestController("adminCommentController")
@RequestMapping("/admin/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;



}
