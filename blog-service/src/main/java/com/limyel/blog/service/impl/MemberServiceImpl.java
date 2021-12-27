package com.limyel.blog.service.impl;

import com.limyel.blog.dao.MemberMapper;
import com.limyel.blog.entity.Member;
import com.limyel.blog.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author limyel
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public int save(Member member) {
        return memberMapper.insertSelective(member);
    }

    @Override
    public int update(Member member) {
        return memberMapper.updateByPrimaryKeySelective(member);
    }

    @Override
    public Member getByInfo(String name, String email) {
        return memberMapper.selectByInfo(name, email);
    }
}
