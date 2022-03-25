package com.limyel.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.limyel.blog.entity.Post;
import com.limyel.blog.vo.PostInArchiveVO;
import com.limyel.blog.vo.PostInHomeVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author limyel
 */
@Repository
public interface PostMapper extends BaseMapper<Post> {

    List<PostInHomeVO> selectInHome();

    List<Integer> selectYear();

    List<Post> selectByYear(int year);

    List<PostInArchiveVO> selectHot();

    List<PostInArchiveVO> selectByTagId(Long tagId);

}