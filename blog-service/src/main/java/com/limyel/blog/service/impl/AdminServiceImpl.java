package com.limyel.blog.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.limyel.blog.dao.AdminMapper;
import com.limyel.blog.entity.Admin;
import com.limyel.blog.entity.dto.AdminLoginDTO;
import com.limyel.blog.service.AdminService;
import com.limyel.blog.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${blog.md5-salt}")
    private String md5Salt;

    @Override
    public Admin getById(Long id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public Admin getByName(String name) {
        Example example = new Example(Admin.class);
        example.createCriteria().andEqualTo("name", name);
        return adminMapper.selectOneByExample(example);
    }

    /**
     * 登录
     * @param admin
     * @param adminLoginDTO
     * @return jwt token
     */
    @Override
    public String login(Admin admin, AdminLoginDTO adminLoginDTO) {
        if (admin.getPassword().equals(DigestUtil.md5Hex(adminLoginDTO.getPassword() + md5Salt))) {
            return jwtUtil.generateJWT(admin.getId());
        }
        return null;
    }


}
