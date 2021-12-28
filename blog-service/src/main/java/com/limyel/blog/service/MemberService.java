package com.limyel.blog.service;

import com.limyel.blog.entity.User;

public interface MemberService {

    int save(User member);

    int update(User member);

    User getByInfo(String name, String email);

}
