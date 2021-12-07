package com.limyel.blog.controller;

import com.limyel.blog.entity.Post;
import com.limyel.blog.entity.PostTag;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.service.PostService;
import com.limyel.blog.common.Response;
import com.limyel.blog.service.PostTagService;
import com.limyel.blog.service.TagService;
import com.limyel.blog.service.impl.TagServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Api(tags = "文章")
@RestController
@RequestMapping("/blog/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostTagService postTagService;

    @Autowired
    private TagService tagService;

    @ApiOperation(value = "文章列表", httpMethod = "GET")
    @GetMapping
    public Response listInHome(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize
    ) {
        return Response.success(postService.pageInHome(pageNum, pageSize));
    }
}
