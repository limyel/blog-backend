package com.limyel.blog.dao;

import com.limyel.blog.entity.AboutItem;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AboutItem record);

    int insertSelective(AboutItem record);

    AboutItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AboutItem record);

    int updateByPrimaryKey(AboutItem record);
}