package com.limyel.blog.service.impl;

import com.limyel.blog.entity.Tag;
import com.limyel.blog.entity.dto.TagInPost;
import com.limyel.blog.mapper.TagMapper;
import com.limyel.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public int save(Tag tag) {
        return tagMapper.insertSelective(tag);
    }

    @Override
    public List<TagInPost> listByPostId(Long postId) {
        return tagMapper.selectByPostId(postId);
    }
}
