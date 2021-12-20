package com.limyel.blog.controller;

import com.limyel.blog.common.Response;
import com.limyel.blog.service.AboutService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Blog 关于")
@RestController
@RequestMapping("/blog/about")
public class AboutController {

    @Autowired
    private AboutService aboutService;

    @ApiOperation(value = "列表", httpMethod = "GET")
    @GetMapping
    public Response list() {
        return Response.success(aboutService.listDetail());
    }

}
