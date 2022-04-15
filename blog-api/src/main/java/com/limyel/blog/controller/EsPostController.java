package com.limyel.blog.controller;

import com.limyel.blog.core.Response;
import com.limyel.blog.service.EsPostService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Post 搜索")
@RestController
@RequestMapping("/search/posts")
public class EsPostController {

    @Autowired
    private EsPostService esPostService;

    @GetMapping("/{keyword}")
    public Response search(
            @PathVariable String keyword
    ) {
        esPostService.findAll(keyword, 0, 10);
        return Response.success();
    }


}