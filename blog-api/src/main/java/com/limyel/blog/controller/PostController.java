package com.limyel.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.common.Response;
import com.limyel.blog.common.util.PageUtil;
import com.limyel.blog.entity.Post;
import com.limyel.blog.vo.PostDetailVO;
import com.limyel.blog.vo.PostInArchiveVO;
import com.limyel.blog.service.PostService;
import com.limyel.blog.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private TagService tagService;

    @ApiOperation(value = "列表", httpMethod = "GET")
    @GetMapping
    public Response<PageUtil> listInHome(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Long pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Long pageSize
    ) {
        return Response.success(postService.pageInHome(pageNum, pageSize));
    }

    @ApiOperation(value = "详情", httpMethod = "GET")
    @GetMapping("/{slug}")
    public Response<PostDetailVO> getDetail(
            @PathVariable("slug") String slug
    ) {
        PostDetailVO postDetail = postService.getDetailBySlug(slug);
        if (postDetail == null) {
            log.error("not found");
            return Response.notFound();
        }
        return Response.success(postDetail);
    }

    @ApiOperation(value = "归档", httpMethod = "GET")
    @GetMapping("/archives")
    public Response<Map<Integer, List<PostInArchiveVO>>> archives() {
        Map<Integer, List<PostInArchiveVO>> result = new HashMap<>();
        for (int year: postService.listYear()) {
            result.put(year, postService.listInArchive(year));
        }
        return Response.success(result);
    }

    @ApiOperation(value = "最热文章", httpMethod = "GET")
    @GetMapping("/hot")
    public Response hot() {
        return Response.success(postService.listHot());
    }

    @ApiOperation(value = "根据标签", httpMethod = "GET")
    @GetMapping("/tag/{slug}")
    public Response getInTag(
            @PathVariable(value = "slug") String slug,
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Long pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Long pageSize
    ) {
        return Response.success(postService.pageByTag(slug, pageNum, pageSize));
    }

    @ApiOperation(value = "获取 about", httpMethod = "GET")
    @GetMapping("/about")
    public Response getAbout() {
        return Response.success(postService.getAbout());
    }

    @ApiOperation(value = "获取周报", httpMethod = "GET")
    @GetMapping("/weekly")
    public Response listWeekly(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Long pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Long pageSize
    ) {
        Page<Post> page = new Page<>(pageNum, pageSize);
        return Response.success(postService.pageWeekly(page));
    }
}
