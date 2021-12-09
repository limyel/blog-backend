package com.limyel.blog.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "评论")
@RestController
@RequestMapping("blog/comments")
public class CommentController {
}
