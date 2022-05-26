package com.limyel.blog.service;

import com.limyel.blog.entity.User;
import com.limyel.blog.dto.AdminLoginDTO;

public interface UserService {

    void save(User member);

    void update(User member);

    User getByInfo(String name, String email);

    User getById(Long id);

    String login(User user, AdminLoginDTO userLoginDTO);
}
