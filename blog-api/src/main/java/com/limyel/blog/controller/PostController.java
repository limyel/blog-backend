package com.limyel.blog.controller;

import com.limyel.blog.common.api.Paging;
import com.limyel.blog.common.api.Response;
import com.limyel.blog.dto.PostDetailDTO;
import com.limyel.blog.dto.PostPureDTO;
import com.limyel.blog.entity.Post;
import com.limyel.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public Response<Paging<PostPureDTO>> list(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize
    ) {
        return Response.success(postService.page(pageNum-1, pageSize));
    }

    @GetMapping("/about")
    public Response<PostDetailDTO> getAbout() {
        return Response.success(postService.getAbout());
    }

    @GetMapping("/{slug}")
    public Response<PostDetailDTO> detail(
            @PathVariable String slug
    ) {
        return Response.success(postService.getBySlug(slug));
    }

    @GetMapping("/by-tag/{slug}")
    public Response<List<PostPureDTO>> pageByTag(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize,
            @PathVariable(name = "slug") String tagSlug
    ) {
        return Response.success(postService.pageByTag(tagSlug));
    }

}
