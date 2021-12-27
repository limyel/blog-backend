package com.limyel.blog.dao;

import com.limyel.blog.entity.Member;
import com.limyel.blog.entity.vo.MemberVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface MemberMapper extends Mapper<Member> {

    MemberVO selectVOById(Long id);

    Member selectByInfo(@Param("name") String name, @Param("email") String email);

}