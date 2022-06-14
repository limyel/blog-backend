package com.limyel.blog.controller;

import com.limyel.blog.common.api.Paging;
import com.limyel.blog.common.api.Response;
import com.limyel.blog.dto.PostDetailDTO;
import com.limyel.blog.dto.PostPureDTO;
import com.limyel.blog.service.PostService;
import com.limyel.blog.vo.HomeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/about")
    public Response<PostDetailDTO> getAbout() {
        return Response.success(postService.getAbout());
    }

    @GetMapping("/by-slug/{slug}")
    public Response<PostDetailDTO> detail(
            @PathVariable String slug
    ) {
        return Response.success(postService.getBySlug(slug));
    }

    @GetMapping("/with-year")
    public Response<HomeVO> pageWithYear(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize,
            @RequestParam(name = "slug", required = false) String tagSlug
    ) {
        return Response.success(postService.pageWithYear(tagSlug, pageNum-1, pageSize));
    }

}
