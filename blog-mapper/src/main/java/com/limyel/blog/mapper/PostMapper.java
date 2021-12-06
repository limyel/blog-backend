package com.limyel.blog.mapper;

import com.limyel.blog.entity.Post;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface PostMapper extends Mapper<Post> {
}