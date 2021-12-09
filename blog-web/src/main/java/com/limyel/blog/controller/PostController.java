package com.limyel.blog.controller;

import com.github.pagehelper.PageInfo;
import com.limyel.blog.entity.Post;
import com.limyel.blog.entity.dto.PostDetail;
import com.limyel.blog.entity.dto.PostInArchive;
import com.limyel.blog.entity.dto.PostInHome;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "文章")
@RestController
@RequestMapping("/blog/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @ApiOperation(value = "列表", httpMethod = "GET")
    @GetMapping
    public Response<PageInfo<PostInHome>> listInHome(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize
    ) {
        return Response.success(postService.pageInHome(pageNum, pageSize));
    }

    @ApiOperation(value = "详情", httpMethod = "GET")
    @GetMapping("/{slug}")
    public Response<PostDetail> getDetail(
            @PathVariable("slug") String slug
    ) {
        PostDetail postDetail = postService.getBySlug(slug);
        if (postDetail == null) {
            return Response.notFound();
        }
        return Response.success(postDetail);
    }

    @ApiOperation(value = "归档", httpMethod = "GET")
    @GetMapping("/archives")
    public Response<Map<Integer, List<PostInArchive>>> archives() {
        Map<Integer, List<PostInArchive>> result = new HashMap<>();
        for (int year: postService.listYear()) {
            result.put(year, postService.listInArchive(year));
        }
        return Response.success(result);
    }

    @ApiOperation(value = "最热文章", httpMethod = "GET")
    @GetMapping("/hot")
    public Response hot() {
        List<PostInArchive> postInArchives = postService.listHot();
        for (PostInArchive post: postInArchives) {
            System.out.println(post.getCreatedAt());
        }
        return Response.success();
    }
}
