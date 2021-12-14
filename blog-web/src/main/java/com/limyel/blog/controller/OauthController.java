package com.limyel.blog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.limyel.blog.common.Response;
import com.limyel.blog.entity.vo.GithubAccessTokenVO;
import com.limyel.blog.service.GithubOauthService;
import com.limyel.blog.utils.OkHttpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "Blog Oauth验证")
@RequestMapping("/blog/oauth")
@RestController
public class OauthController {

    @Autowired
    private GithubOauthService githubOauthService;

    @ApiOperation(value = "GitHub", httpMethod = "GET")
    @GetMapping("/github")
    public Response github(
            @RequestParam(value = "code") String code,
            @RequestParam(value = "postId") Long postId
    ) {
        githubOauthService.bindAccount(code);
        return Response.success();
    }

}
