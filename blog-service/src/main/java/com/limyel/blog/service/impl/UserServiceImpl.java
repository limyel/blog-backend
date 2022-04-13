package com.limyel.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.limyel.blog.dao.UserMapper;
import com.limyel.blog.entity.User;
import com.limyel.blog.dto.AdminLoginDTO;
import com.limyel.blog.service.UserService;
import com.limyel.blog.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author limyel
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public int save(User member) {
        return userMapper.insert(member);
    }

    @Override
    public int update(User member) {
        return userMapper.updateById(member);
    }

    @Override
    public User getByInfo(String name, String email) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getName, name);
        wrapper.eq(User::getEmail, email);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public User getById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public String login(User user, AdminLoginDTO userLoginDTO) {

        return null;
    }
}
