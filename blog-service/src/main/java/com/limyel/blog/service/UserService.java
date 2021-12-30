package com.limyel.blog.service;

import com.limyel.blog.entity.User;

public interface UserService {

    int save(User member);

    int update(User member);

    User getByInfo(String name, String email);

    User getById(Long id);
}
