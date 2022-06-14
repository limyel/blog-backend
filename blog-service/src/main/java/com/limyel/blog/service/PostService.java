package com.limyel.blog.service;

import com.limyel.blog.common.api.Paging;
import com.limyel.blog.dto.PostDetailDTO;
import com.limyel.blog.dto.PostPureDTO;
import com.limyel.blog.vo.HomeVO;

import java.util.List;
import java.util.Map;

public interface PostService {

    HomeVO pageWithYear(String tagSlug, Integer pageNum, Integer pageSize);

    Paging<PostPureDTO> page(Integer pageNum, Integer pageSize);

    PostDetailDTO getBySlug(String slug);

    PostDetailDTO getAbout();
}
