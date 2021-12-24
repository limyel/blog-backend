package com.limyel.blog.service;

import com.github.pagehelper.PageInfo;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.entity.vo.TagDetailVO;
import com.limyel.blog.entity.vo.TagInPostVO;
import com.limyel.blog.entity.dto.TagDTO;

import java.util.List;

public interface TagService {

    int save(Tag tag);

    List<TagInPostVO> listByPostId(Long postId);

    List<TagDetailVO> listDetail();

    Tag getBySlug(String slug);

    int countByIds(List<Long> ids);

    Tag getById(Long id);

    int delete(Tag tag);

    int update(Tag tag, TagDTO vo);

    PageInfo<Tag> page(int pageNum, int pageSize);
}
