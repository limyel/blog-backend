package com.limyel.blog.service;

import com.limyel.blog.entity.Member;

public interface GithubOauthService {

    Member bindAccount(String code);

}
