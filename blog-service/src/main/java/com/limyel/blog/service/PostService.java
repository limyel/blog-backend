package com.limyel.blog.service;

import com.limyel.blog.common.api.Paging;
import com.limyel.blog.dto.PostDetailDTO;
import com.limyel.blog.dto.PostPureDTO;

import javax.transaction.Transactional;
import java.util.List;

public interface PostService {

    Paging<PostPureDTO> page(Integer pageNum, Integer pageSize);

    PostDetailDTO getBySlug(String slug);

    List<PostPureDTO> pageByTag(String tagSlug, Integer pageNum, Integer pageSize);

    PostDetailDTO getAbout();
}
