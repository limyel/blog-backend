package com.limyel.blog.controller;

import com.limyel.blog.common.Response;
import com.limyel.blog.entity.Member;
import com.limyel.blog.entity.vo.MemberVO;
import com.limyel.blog.service.GithubOauthService;
import com.limyel.blog.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "Blog Oauth2.0验证")
@RequestMapping("/blog/oauth")
@RestController
public class OauthController {

    @Autowired
    private GithubOauthService githubOauthService;

    @Autowired
    private JwtUtil jwtUtil;

    @ApiOperation(value = "GitHub", httpMethod = "GET")
    @GetMapping("/github")
    public Response github(
            @RequestParam(value = "code") String code
    ) {
        MemberVO memberVO = githubOauthService.bindAccount(code);
        String jwt = jwtUtil.generateJWT(memberVO.getId());
        Map<String, Object> result = new HashMap<>();
        result.put("jwt", jwt);
        result.put("memberInfo", memberVO);

        return Response.success(result);
    }

}
