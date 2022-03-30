package com.limyel.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.limyel.blog.common.exception.BlogException;
import com.limyel.blog.core.util.PageUtil;
import com.limyel.blog.entity.PostTag;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.vo.PostDetailVO;
import com.limyel.blog.vo.PostInArchiveVO;
import com.limyel.blog.vo.PostInHomeVO;
import com.limyel.blog.dao.PostMapper;
import com.limyel.blog.entity.Post;
import com.limyel.blog.dto.PostDTO;
import com.limyel.blog.service.PostService;
import com.limyel.blog.service.PostTagService;
import com.limyel.blog.service.TagService;
import com.limyel.blog.utils.BeanUtil;
import com.limyel.blog.utils.SlugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private TagService tagService;

    @Autowired
    private PostTagService postTagService;

    @Override
    public Post getById(Long id) {
        return postMapper.selectById(id);
    }

    @Override
    public PageUtil pageInHome(Long pageNum, Long pageSize) {
        Page<Post> page = new Page<>(pageNum, pageSize);
//        Page<Post> postPage = this.page(page);

        Page<PostInHomeVO> postPage = postMapper.selectInHome(page);
        return new PageUtil(postPage);
    }

    @Override
    public int save(PostDTO vo) {
        Post post = BeanUtil.copy(vo, Post.class);
        post.setSlug(SlugUtil.generate(vo.getTitle()));

        if (!validateTags(vo.getTagIds())) {
            throw new BlogException("标签不存在");
        }
        int result = postMapper.insert(post);

        for (Long tagId: vo.getTagIds()) {
            PostTag postTag = new PostTag();
            postTag.setPostId(post.getId());
            postTag.setTagId(tagId);
            postTagService.save(postTag);
        }

        return result;
    }

    @Override
    public PostDetailVO getDetailById(Long id) {
        Post post = postMapper.selectById(id);
        if (post == null) {
            return null;
        }
        PostDetailVO postDetail = BeanUtil.copy(post, PostDetailVO.class);
        // todo tag 只需要 id
        postDetail.setTags(tagService.listByPostId(post.getId()));
        postDetail.setTagIds(new ArrayList<>());
        postDetail.getTags().forEach(tag -> postDetail.getTagIds().add(tag.getId()));
        return postDetail;
    }

    @Override
    public PostDetailVO getDetailBySlug(String slug) {
        QueryWrapper<Post> wrapper = new QueryWrapper<>();
        wrapper.eq("deleted", false);
        wrapper.eq("slug", slug);
        Post post = postMapper.selectOne(wrapper);
        PostDetailVO postDetail = BeanUtil.copy(post, PostDetailVO.class);
        postDetail.setTags(tagService.listByPostId(post.getId()));
        return postDetail;
    }

    @Override
    public List<Integer> listYear() {
        return postMapper.selectYear();
    }

    @Override
    public List<PostInArchiveVO> listInArchive(int year) {
        List<Post> posts = postMapper.selectByYear(year);

        return BeanUtil.copyList(posts, PostInArchiveVO.class);
    }

    @Override
    public List<PostInArchiveVO> listHot() {
        return postMapper.selectHot();
    }

    @Override
    public PageUtil pageByTag(String slug, Long pageNum, Long pageSize) {
        Tag tag = tagService.getBySlug(slug);

        Page<Post> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Post> wrapper = new QueryWrapper<>();
        wrapper.eq("tag_id", tag.getId());
        Page<Post> postPage = postMapper.selectPage(page, wrapper);

        return new PageUtil(postPage);
    }

    @Override
    public int update(Post post, PostDTO vo) {
        if (!validateTags(vo.getTagIds())) {
            throw new BlogException("标签不存在");
        }
        post.setTitle(vo.getTitle());
        post.setContent(vo.getContent());
        post.setIntroduction(vo.getIntroduction());
        post.setSlug(SlugUtil.generate(vo.getTitle()));

        return postMapper.updateById(post);
    }

    @Override
    public int delete(Post post) {
        post.setDeleted(true);
        return postMapper.updateById(post);
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
