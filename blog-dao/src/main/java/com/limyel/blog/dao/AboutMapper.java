package com.limyel.blog.dao;

import com.limyel.blog.entity.About;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutMapper {
    int deleteByPrimaryKey(Long id);

    int insert(About record);

    int insertSelective(About record);

    About selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(About record);

    int updateByPrimaryKey(About record);
}