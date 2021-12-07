package com.limyel.blog.service.impl;

import com.limyel.blog.entity.Tag;
import com.limyel.blog.mapper.TagMapper;
import com.limyel.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public int save(Tag tag) {
        return tagMapper.insertSelective(tag);
    }
}
