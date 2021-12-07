package com.limyel.blog.controller;

import com.limyel.blog.entity.Post;
import com.limyel.blog.entity.dto.PostDetail;
import com.limyel.blog.service.PostService;
import com.limyel.blog.common.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "文章")
@RestController
@RequestMapping("/blog/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @ApiOperation(value = "列表", httpMethod = "GET")
    @GetMapping
    public Response listInHome(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize
    ) {
        return Response.success(postService.pageInHome(pageNum, pageSize));
    }

    @ApiOperation(value = "详情", httpMethod = "GET")
    @GetMapping("/{id}")
    public Response getDetail(
            @PathVariable("id") Long id
    ) {
        System.out.println(id);
        PostDetail postDetail = postService.getById(id);
        if (postDetail == null) {
            return Response.notFound();
        }
        return Response.success(postDetail);
    }
}
