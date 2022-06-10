package com.limyel.blog.service;

import com.limyel.blog.common.api.Paging;
import com.limyel.blog.dto.PostDetailDTO;
import com.limyel.blog.dto.PostPureDTO;

import java.util.List;
import java.util.Map;

public interface PostService {

    Map<Integer, List<PostPureDTO>> pageInHome(Integer pageNum, Integer pageSize);

    Paging<PostPureDTO> page(Integer pageNum, Integer pageSize);

    PostDetailDTO getBySlug(String slug);

    Paging<PostPureDTO> pageByTag(String tagSlug, Integer pageNum, Integer pageSize);

    PostDetailDTO getAbout();
}
