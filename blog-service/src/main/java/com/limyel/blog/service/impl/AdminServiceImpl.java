package com.limyel.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.limyel.blog.dao.AdminMapper;
import com.limyel.blog.entity.Admin;
import com.limyel.blog.dto.AdminLoginDTO;
import com.limyel.blog.service.AdminService;
import com.limyel.blog.common.util.JwtUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${blog.md5-salt}")
    private String md5Salt;

    @Override
    public Admin getById(Long id) {
        return adminMapper.selectById(id);
    }

    @Override
    public Admin getByName(String name) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        return adminMapper.selectOne(wrapper);
    }

    /**
     * 登录
     * @param admin
     * @param adminLoginDTO
     * @return jwt token
     */
    @Override
    public String login(Admin admin, AdminLoginDTO adminLoginDTO) {
        if (admin.getPassword().equals(DigestUtils.md5Hex(adminLoginDTO.getPassword() + md5Salt))) {
            return jwtUtil.generateJWT(admin.getId());
        }
        return null;
    }


}
