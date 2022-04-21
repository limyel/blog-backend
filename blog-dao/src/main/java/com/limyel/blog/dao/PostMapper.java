package com.limyel.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.entity.Post;
import com.limyel.blog.vo.PostInArchiveVO;
import com.limyel.blog.vo.PostInHomeVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostMapper extends BaseMapper<Post> {

    Page<PostInHomeVO> selectInHome(Page<PostInHomeVO> page);

    List<Integer> selectYear();

    List<Post> selectByYear(int year);

    List<PostInArchiveVO> selectHot();

    IPage<PostInArchiveVO> selectByTagId(Page<Post> page, Long tagId);
}