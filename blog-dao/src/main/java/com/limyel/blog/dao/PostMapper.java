package com.limyel.blog.dao;

import com.limyel.blog.entity.Post;
import com.limyel.blog.entity.dto.PostInArchive;
import com.limyel.blog.entity.dto.PostInHome;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface PostMapper extends Mapper<Post> {

    List<PostInHome> selectInHome();

    List<Integer> selectYear();

    List<Post> selectByYear(int year);

    List<PostInArchive> selectHot();

    List<PostInArchive> selectByTagId(Long tagId);

}