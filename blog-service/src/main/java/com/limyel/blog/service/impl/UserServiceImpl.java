package com.limyel.blog.service.impl;

import com.limyel.blog.dao.UserMapper;
import com.limyel.blog.entity.User;
import com.limyel.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author limyel
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(User member) {
        return userMapper.insertSelective(member);
    }

    @Override
    public int update(User member) {
        return userMapper.updateByPrimaryKeySelective(member);
    }

    @Override
    public User getByInfo(String name, String email) {
        return userMapper.selectByInfo(name, email);
    }

    @Override
    public User getById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
