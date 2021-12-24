package com.limyel.blog.service;

import com.limyel.blog.entity.Member;
import com.limyel.blog.entity.vo.MemberVO;

public interface GithubOauthService {

    MemberVO bindAccount(String code);

}
