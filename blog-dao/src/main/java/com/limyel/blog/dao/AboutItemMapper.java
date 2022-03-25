package com.limyel.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.limyel.blog.entity.AboutItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AboutItemMapper extends BaseMapper<AboutItem> {

    List<AboutItem> selectByAboutId(Long aboutId);

    int deleteByAboutId(Long aboutId);
}