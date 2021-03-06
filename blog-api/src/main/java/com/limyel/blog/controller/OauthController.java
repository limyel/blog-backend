package com.limyel.blog.controller;

import com.limyel.blog.common.api.Response;
import com.limyel.blog.vo.UserVO;
import com.limyel.blog.service.GithubOauthService;
import com.limyel.blog.common.utils.JwtUtil;
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
        UserVO userVO = githubOauthService.bindAccount(code);
        String jwt = jwtUtil.generateJWT(userVO.getId());
        Map<String, Object> result = new HashMap<>();
        result.put("jwt", jwt);
        result.put("userInfo", userVO);

        return Response.success(result);
    }

}
