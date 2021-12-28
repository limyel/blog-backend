package com.limyel.blog.dao;

import com.limyel.blog.entity.User;
import com.limyel.blog.entity.vo.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {

    UserVO selectVOById(Long id);

    User selectByInfo(@Param("name") String name, @Param("email") String email);

}