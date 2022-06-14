package com.limyel.blog.service.impl;

import com.limyel.blog.common.api.Paging;
import com.limyel.blog.dao.TagRepository;
import com.limyel.blog.dto.TagDetailDTO;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Paging<TagDetailDTO> page(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Tag> page = tagRepository.findTagByOrderByCreateTimeDesc(pageable);
        List<TagDetailDTO> result = page.getContent().stream().map(TagDetailDTO::new).collect(Collectors.toList());
        return new Paging<>(page, result);
    }
}
