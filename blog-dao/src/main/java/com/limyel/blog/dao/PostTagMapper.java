package com.limyel.blog.dao;

import com.limyel.blog.entity.PostTag;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author limyel
 */
@Repository
public interface PostTagMapper extends Mapper<PostTag> {
}