package com.limyel.blog.service;

import com.limyel.blog.entity.Admin;
import com.limyel.blog.entity.dto.AdminLoginDTO;

public interface AdminService {

    Admin getById(Long id);

    Admin getByName(String name);

    String login(Admin admin, AdminLoginDTO adminLoginDTO);

}
