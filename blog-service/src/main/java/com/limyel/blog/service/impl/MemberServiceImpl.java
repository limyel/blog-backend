package com.limyel.blog.service.impl;

import com.limyel.blog.dao.UserMapper;
import com.limyel.blog.entity.User;
import com.limyel.blog.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author limyel
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private UserMapper memberMapper;

    @Override
    public int save(User member) {
        return memberMapper.insertSelective(member);
    }

    @Override
    public int update(User member) {
        return memberMapper.updateByPrimaryKeySelective(member);
    }

    @Override
    public User getByInfo(String name, String email) {
        return memberMapper.selectByInfo(name, email);
    }
}
