package com.limyel.blog.dao;

import com.limyel.blog.entity.AboutItem;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AboutItemMapper extends Mapper<AboutItem> {

    List<AboutItem> selectByAboutId(Long aboutId);

    int deleteByAboutId(Long aboutId);
}