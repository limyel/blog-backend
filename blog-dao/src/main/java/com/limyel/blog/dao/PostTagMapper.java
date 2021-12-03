package com.limyel.blog.dao;

import com.limyel.blog.entity.PostTag;
import org.springframework.stereotype.Repository;

@Repository
public interface PostTagMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PostTag record);

    int insertSelective(PostTag record);

    PostTag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PostTag record);

    int updateByPrimaryKey(PostTag record);
}