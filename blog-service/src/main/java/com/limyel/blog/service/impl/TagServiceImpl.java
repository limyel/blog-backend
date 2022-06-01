package com.limyel.blog.service.impl;

import com.limyel.blog.dao.TagRepository;
import com.limyel.blog.dto.TagDetailDTO;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<TagDetailDTO> list() {
        List<Tag> all = tagRepository.findAll();
        return all.stream().map(tag -> {
            TagDetailDTO tagDetailDTO = new TagDetailDTO(tag);
            // todo postNum
            return tagDetailDTO;
        }).collect(Collectors.toList());
    }
}
