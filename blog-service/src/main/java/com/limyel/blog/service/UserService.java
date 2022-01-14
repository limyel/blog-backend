package com.limyel.blog.service;

import com.limyel.blog.entity.User;
import com.limyel.blog.entity.dto.AdminLoginDTO;

public interface UserService {

    int save(User member);

    int update(User member);

    User getByInfo(String name, String email);

    User getById(Long id);

    String login(User user, AdminLoginDTO userLoginDTO);
}
