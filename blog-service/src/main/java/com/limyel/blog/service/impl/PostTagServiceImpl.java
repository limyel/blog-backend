package com.limyel.blog.service.impl;

import com.limyel.blog.entity.PostTag;
import com.limyel.blog.mapper.PostTagMapper;
import com.limyel.blog.service.PostTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostTagServiceImpl implements PostTagService {

    @Autowired
    private PostTagMapper postTagMapper;

    @Override
    public int save(PostTag postTag) {
        return postTagMapper.insertSelective(postTag);
    }
}
