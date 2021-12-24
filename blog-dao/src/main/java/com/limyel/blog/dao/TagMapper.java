package com.limyel.blog.dao;

import com.limyel.blog.entity.Tag;
import com.limyel.blog.entity.vo.TagDetailVO;
import com.limyel.blog.entity.vo.TagInPostVO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TagMapper extends Mapper<Tag> {

    List<TagInPostVO> selectByPostId(Long postId);

    List<TagDetailVO> selectDetail();

    Integer selectCountByIds(List<Long> ids);
}