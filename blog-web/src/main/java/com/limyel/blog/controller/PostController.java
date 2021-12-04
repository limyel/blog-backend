package com.limyel.blog.controller;

import com.limyel.blog.service.PostService;
import com.limyel.blog.common.Response;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "文章")
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    public Response list(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize
    ) {
        return null;
    }
}
