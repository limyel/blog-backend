package com.limyel.blog.controller;

import com.limyel.blog.common.api.Response;
import com.limyel.blog.dto.TagDetailDTO;
import com.limyel.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public Response<List<TagDetailDTO>> list() {
        return Response.success(tagService.list());
    }

}
