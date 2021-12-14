package com.limyel.blog.dao;

import com.limyel.blog.entity.Member;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface MemberMapper extends Mapper<Member> {
}