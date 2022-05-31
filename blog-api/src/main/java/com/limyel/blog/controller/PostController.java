package com.limyel.blog.controller;

import com.limyel.blog.common.api.Paging;
import com.limyel.blog.common.api.Response;
import com.limyel.blog.vo.PostDetailVO;
import com.limyel.blog.service.PostService;
import com.limyel.blog.vo.PostPureVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author limyel
 */
@Slf4j
@Api(tags = "Blog 文章")
@RestController
@RequestMapping("/blog/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @ApiOperation(value = "列表", httpMethod = "GET")
    @GetMapping
    public Response<Paging<PostPureVO>> listInHome(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") int pageSize
    ) {
        return Response.success(postService.pageInHome(pageNum, pageSize));
    }

    @ApiOperation(value = "详情", httpMethod = "GET")
    @GetMapping("/{slug}")
    public Response<PostDetailVO> getDetail(
            @PathVariable("slug") String slug
    ) {
        PostDetailVO postDetail = postService.getDetail(slug);
        return Response.success(postDetail);
    }

    @ApiOperation(value = "获取 about", httpMethod = "GET")
    @GetMapping("/about")
    public Response<PostDetailVO> getAbout() {
        return Response.success(postService.getAbout());
    }

}
