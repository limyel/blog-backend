package com.limyel.blog.dao;

import com.limyel.blog.entity.Post;
import com.limyel.blog.entity.vo.PostInArchiveVO;
import com.limyel.blog.entity.vo.PostInHomeVO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface PostMapper extends Mapper<Post> {

    List<PostInHomeVO> selectInHome();

    List<Integer> selectYear();

    List<Post> selectByYear(int year);

    List<PostInArchiveVO> selectHot();

    List<PostInArchiveVO> selectByTagId(Long tagId);

}