package com.limyel.blog.service.impl;

import com.github.pagehelper.PageInfo;
import com.limyel.blog.mapper.PostMapper;
import com.limyel.blog.entity.Post;
import com.limyel.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public List<Post> list() {
        List<Post> result = postMapper.selectAll();
        return result;
    }

    @Override
    public int create(Post post) {
        return postMapper.insertSelective(post);
    }
}
