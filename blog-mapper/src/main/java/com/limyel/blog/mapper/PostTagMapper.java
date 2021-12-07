package com.limyel.blog.mapper;

import com.limyel.blog.entity.PostTag;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface PostTagMapper extends Mapper<PostTag> {
}