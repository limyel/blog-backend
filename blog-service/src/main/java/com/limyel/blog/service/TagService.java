package com.limyel.blog.service;

import com.limyel.blog.core.util.PageUtil;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.vo.TagDetailVO;
import com.limyel.blog.vo.TagInPostVO;
import com.limyel.blog.dto.TagDTO;

import java.util.List;
import java.util.Optional;

public interface TagService {

    int save(Tag tag);

    List<TagInPostVO> listByPostId(Long postId);

    List<TagDetailVO> listDetail();

    Tag getBySlug(String slug);

    int countByIds(List<Long> ids);

    Tag getById(Long id);

    int delete(Tag tag);

    int update(Tag tag, TagDTO vo);

    PageUtil page(Long pageNum, Long pageSize);
}
