package com.limyel.blog.service;

import com.github.pagehelper.PageInfo;
import com.limyel.blog.entity.Post;
import com.limyel.blog.entity.dto.PostInHome;

import java.util.List;

public interface PostService {

    PageInfo<PostInHome> pageInHome(int pageNum, int pageSize);

    int save(Post post);

}
