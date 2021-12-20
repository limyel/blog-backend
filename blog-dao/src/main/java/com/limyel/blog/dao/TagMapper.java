package com.limyel.blog.dao;

import com.limyel.blog.entity.Tag;
import com.limyel.blog.entity.dto.TagDetail;
import com.limyel.blog.entity.dto.TagInPost;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TagMapper extends Mapper<Tag> {

    List<TagInPost> selectByPostId(Long postId);

    List<TagDetail> selectDetail();

    Integer selectCountByIds(List<Long> ids);
}