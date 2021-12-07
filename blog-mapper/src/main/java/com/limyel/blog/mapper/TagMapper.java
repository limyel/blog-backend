package com.limyel.blog.mapper;

import com.limyel.blog.entity.Tag;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface TagMapper extends Mapper<Tag> {
}