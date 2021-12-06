package com.limyel.blog.service;

import com.github.pagehelper.PageInfo;
import com.limyel.blog.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> list();

    int create(Post post);

}
