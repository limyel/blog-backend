package com.limyel.blog.controller;

import com.limyel.blog.common.api.Response;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.vo.TagDetailVO;
import com.limyel.blog.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(tags = "Blog 标签")
@RestController
@RequestMapping("/blog/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @ApiOperation(value = "列表", httpMethod = "GET")
    @GetMapping
    public Response<List<TagDetailVO>> list() {
        List<TagDetailVO> result = tagService.listDetail();
        return Response.success(result);
    }

    @ApiOperation(value = "详情", httpMethod = "GET")
    @GetMapping("/{slug}")
    public Response getBySlug(
            @PathVariable("slug") String slug
    ) {
        Tag tag = tagService.getBySlug(slug);
        return Response.success(tag);
    }

}
