package com.limyel.blog.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.limyel.blog.common.exception.BlogException;
import com.limyel.blog.entity.User;
import com.limyel.blog.entity.dto.GithubAccessTokenDTO;
import com.limyel.blog.entity.dto.GithubUserInfoDTO;
import com.limyel.blog.entity.vo.UserVO;
import com.limyel.blog.service.GithubOauthService;
import com.limyel.blog.service.MemberService;
import com.limyel.blog.utils.BeanUtil;
import com.limyel.blog.utils.OkHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author limyel
 */
@Service
public class GithubOauthServiceImpl implements GithubOauthService {

    @Value("${github.clientId}")
    private String clientId;

    @Value("${github.clientSecret}")
    private String clientSecret;

    @Value("${github.accessTokenURL}")
    private String accessTokenURL;

    @Value("${github.userInfoURL}")
    private String userInfoURL;

    @Autowired
    private OkHttpUtil okHttpUtil;

    @Autowired
    private MemberService memberService;

    @Override
    public UserVO bindAccount(String code) {
        Map<String, String> params = new HashMap<>();
        params.put("client_id", clientId);
        params.put("client_secret", clientSecret);
        params.put("code", code);
        String accessToken = getAccessToken(params);
        if (accessToken == null) {
            throw new BlogException("获取 GitHub access token 失败");
        }
        User member = getMemberInfo(accessToken);
        if (member == null) {
            throw new BlogException("获取 GitHub 用户信息失败");
        }
        User oldMember = memberService.getByInfo(member.getName(), member.getEmail());
        if (oldMember != null) {
            member.setId(oldMember.getId());
            BeanUtil.cover(member, oldMember);
            memberService.update(oldMember);
        } else {
            memberService.save(member);
        }

        return BeanUtil.copy(member, UserVO.class);
    }

    private User getMemberInfo(String accessToken) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "token " + accessToken);
        headers.put("Accept", "application/json");
        String result = okHttpUtil.doGetWithHeaders(userInfoURL, headers);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        try {
            GithubUserInfoDTO vo = objectMapper.readValue(result, GithubUserInfoDTO.class);
            User member = new User();
            member.setAvatarUrl(vo.getAvatarUrl());
            member.setEmail(vo.getEmail());
            member.setHtmlUrl(vo.getHtmlUrl());
            member.setName(vo.getName());
            return member;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getAccessToken(Map<String, String> params) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        String result = okHttpUtil.doPost(accessTokenURL, params, headers);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        try {
            GithubAccessTokenDTO vo = objectMapper.readValue(result, GithubAccessTokenDTO.class);
            return vo.getAccessToken();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
