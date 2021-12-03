package com.limyel.blog.controller;

import com.limyel.blog.service.PostService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "文章")
@RestController
public class PostController {

    @Autowired
    private PostService postService;



}
