package com.limyel.blog.controller;

import com.limyel.blog.common.api.Paging;
import com.limyel.blog.common.api.Response;
import com.limyel.blog.dto.TagDetailDTO;
import com.limyel.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public Response<Paging<TagDetailDTO>> page(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize
    ) {
        return Response.success(tagService.page(pageNum-1, pageSize));
    }

}
