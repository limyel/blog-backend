package com.limyel.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.vo.TagDetailVO;
import com.limyel.blog.vo.TagInPostVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagMapper extends BaseMapper<Tag> {

    List<TagInPostVO> selectByPostId(Long postId);

    List<TagDetailVO> selectDetail();

}