package com.limyel.blog.controller.admin;

import com.limyel.blog.service.CommentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author limyel
 */
@Api(tags = "Admin 评论")
@RestController("adminCommentController")
@RequestMapping("/admin/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

}
