package com.limyel.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.limyel.blog.entity.Admin;
import com.limyel.blog.dto.AdminLoginDTO;

public interface AdminService extends IService<Admin> {

    Admin getById(Long id);

    Admin getByName(String name);

    String login(Admin admin, AdminLoginDTO adminLoginDTO);

}
