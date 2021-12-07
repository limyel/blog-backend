package com.limyel.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.limyel.blog.entity.dto.PostInHome;
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
    public PageInfo<PostInHome> pageInHome(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PostInHome> posts = postMapper.selectPostInHome();
        PageInfo<PostInHome> pageInfo = new PageInfo<>(posts);
        pageInfo.setTotal(posts.size());
        return pageInfo;
    }

    @Override
    public int save(Post post) {
        return postMapper.insertSelective(post);
    }
}
