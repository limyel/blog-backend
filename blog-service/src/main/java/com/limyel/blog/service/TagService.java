package com.limyel.blog.service;

import com.limyel.blog.common.api.Paging;
import com.limyel.blog.dto.TagDetailDTO;

import java.util.List;

public interface TagService {

    Paging<TagDetailDTO> page(Integer pageNum, Integer pageSize);

}
