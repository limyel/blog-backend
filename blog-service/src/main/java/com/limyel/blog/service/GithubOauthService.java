package com.limyel.blog.service;

import com.limyel.blog.vo.UserVO;

public interface GithubOauthService {

    UserVO bindAccount(String code);

}
