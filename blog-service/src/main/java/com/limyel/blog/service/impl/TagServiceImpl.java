package com.limyel.blog.service.impl;

import com.limyel.blog.dao.TagRepository;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.service.TagService;
import com.limyel.blog.vo.TagDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<TagDetailVO> listDetail() {
        List<Tag> tagList = tagRepository.findTagsByOrderByCreateTimeDesc();
        return tagList.stream().map(TagDetailVO::new).collect(Collectors.toList());
    }
}
