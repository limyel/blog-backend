package com.limyel.blog.service;

import com.limyel.blog.entity.Tag;
import com.limyel.blog.entity.dto.TagDetail;
import com.limyel.blog.entity.dto.TagInPost;

import java.util.List;

public interface TagService {

    int save(Tag tag);

    List<TagInPost> listByPostId(Long postId);

    List<TagDetail> listDetail();

    Tag getBySlug(String slug);

    int countByIds(List<Long> ids);
}
