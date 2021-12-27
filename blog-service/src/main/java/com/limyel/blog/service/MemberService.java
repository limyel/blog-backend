package com.limyel.blog.service;

import com.limyel.blog.entity.Member;

public interface MemberService {

    int save(Member member);

    int update(Member member);

    Member getByInfo(String name, String email);

}
