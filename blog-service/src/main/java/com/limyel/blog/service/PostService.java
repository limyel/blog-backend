package com.limyel.blog.service;

import com.limyel.blog.common.api.Paging;
import com.limyel.blog.vo.PostDetailVO;
import com.limyel.blog.vo.PostPureVO;

public interface PostService {

    Paging<PostPureVO> pageInHome(Integer pageNum, Integer pageSize);

    PostDetailVO getDetail(String slug);

    PostDetailVO getAbout();
}
