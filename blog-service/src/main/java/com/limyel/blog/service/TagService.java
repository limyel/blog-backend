package com.limyel.blog.service;

import com.github.pagehelper.PageInfo;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.entity.dto.TagDetail;
import com.limyel.blog.entity.dto.TagInPost;
import com.limyel.blog.entity.vo.TagVO;

import java.util.List;

public interface TagService {

    int save(Tag tag);

    List<TagInPost> listByPostId(Long postId);

    List<TagDetail> listDetail();

    Tag getBySlug(String slug);

    int countByIds(List<Long> ids);

    Tag getById(Long id);

    int delete(Tag tag);

    int update(Tag tag, TagVO vo);

    PageInfo<Tag> page(int pageNum, int pageSize);
}
