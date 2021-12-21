package com.limyel.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.limyel.blog.common.exception.BlogException;
import com.limyel.blog.entity.PostTag;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.entity.dto.PostDetail;
import com.limyel.blog.entity.dto.PostInArchive;
import com.limyel.blog.entity.dto.PostInHome;
import com.limyel.blog.dao.PostMapper;
import com.limyel.blog.entity.Post;
import com.limyel.blog.entity.vo.PostVO;
import com.limyel.blog.service.PostService;
import com.limyel.blog.service.PostTagService;
import com.limyel.blog.service.TagService;
import com.limyel.blog.utils.BeanUtil;
import com.limyel.blog.utils.SlugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private TagService tagService;

    @Autowired
    private PostTagService postTagService;

    @Override
    public Post getById(Long id) {
        return postMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<PostInHome> pageInHome(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PostInHome> posts = postMapper.selectInHome();
        PageInfo<PostInHome> pageInfo = new PageInfo<>(posts);
        pageInfo.setTotal(posts.size());
        return pageInfo;
    }

    @Override
    public int save(PostVO vo) {
        Post post = BeanUtil.copy(vo, Post.class);
        post.setSlug(SlugUtil.generate(vo.getTitle()));

        if (!validateTags(vo.getTags())) {
            throw new BlogException("标签不存在");
        }
        int result = postMapper.insertSelective(post);

        for (Long tagId: vo.getTags()) {
            PostTag postTag = new PostTag();
            postTag.setPostId(post.getId());
            postTag.setTagId(tagId);
            postTagService.save(postTag);
        }

        return result;
    }

    @Override
    public PostDetail getDetailById(Long id) {
        Post post = postMapper.selectByPrimaryKey(id);
        if (post == null) {
            return null;
        }
        PostDetail postDetail = BeanUtil.copy(post, PostDetail.class);
        postDetail.setTags(tagService.listByPostId(post.getId()));
        return postDetail;
    }

    @Override
    public PostDetail getDetailBySlug(String slug) {
        Post record = new Post();
        record.setDeleted(false);
        record.setSlug(slug);
        Post post = postMapper.selectOne(record);
        PostDetail postDetail = BeanUtil.copy(post, PostDetail.class);
        postDetail.setTags(tagService.listByPostId(post.getId()));
        return postDetail;
    }

    @Override
    public List<Integer> listYear() {
        return postMapper.selectYear();
    }

    @Override
    public List<PostInArchive> listInArchive(int year) {
        List<Post> posts = postMapper.selectByYear(year);

        return BeanUtil.copyList(posts, PostInArchive.class);
    }

    @Override
    public List<PostInArchive> listHot() {
        return postMapper.selectHot();
    }

    @Override
    public PageInfo<PostInArchive> pageInTag(Tag tag, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PostInArchive> posts = postMapper.selectByTagId(tag.getId());
        PageInfo<PostInArchive> pageInfo = new PageInfo<>(posts);
        return pageInfo;
    }

    @Override
    public int update(Post post, PostVO vo) {
        if (!validateTags(vo.getTags())) {
            throw new BlogException("标签不存在");
        }
        post.setTitle(vo.getTitle());
        post.setContent(vo.getContent());
        post.setIntroduction(vo.getIntroduction());
        post.setSlug(SlugUtil.generate(vo.getTitle()));

        return postMapper.updateByPrimaryKeySelective(post);
    }

    @Override
    public int delete(Post post) {
        post.setDeleted(true);
        return postMapper.updateByPrimaryKey(post);
    }


    /**
     * 验证标签是否正确
     * @param ids
     * @return
     */
    private boolean validateTags(List<Long> ids) {
        return tagService.countByIds(ids) == ids.size();
    }
}
