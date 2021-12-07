package com.limyel.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.limyel.blog.entity.dto.PostDetail;
import com.limyel.blog.entity.dto.PostInHome;
import com.limyel.blog.mapper.PostMapper;
import com.limyel.blog.entity.Post;
import com.limyel.blog.service.PostService;
import com.limyel.blog.service.TagService;
import com.limyel.blog.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private TagService tagService;

    @Override
    public PageInfo<PostInHome> pageInHome(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PostInHome> posts = postMapper.selectInHome();
        System.out.println(posts.get(0).getTags());
        PageInfo<PostInHome> pageInfo = new PageInfo<>(posts);
        pageInfo.setTotal(posts.size());
        return pageInfo;
    }

    @Override
    public int save(Post post) {
        return postMapper.insertSelective(post);
    }

    @Override
    public PostDetail getById(Long id) {
        Post post = postMapper.selectByPrimaryKey(id);
        if (post == null) {
            return null;
        }
        PostDetail postDetail = BeanUtil.copy(post, PostDetail.class);
        postDetail.setTags(tagService.listByPostId(post.getId()));
        return postDetail;
    }
}
