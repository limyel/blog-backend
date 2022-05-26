package com.limyel.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.limyel.blog.common.exception.ApiException;
import com.limyel.blog.common.utils.PageUtil;
import com.limyel.blog.dao.PostRepository;
import com.limyel.blog.entity.PostTag;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.vo.*;
import com.limyel.blog.dao.PostMapper;
import com.limyel.blog.entity.Post;
import com.limyel.blog.dto.PostDTO;
import com.limyel.blog.service.PostService;
import com.limyel.blog.service.PostTagService;
import com.limyel.blog.service.TagService;
import com.limyel.blog.common.utils.BeanUtil;
import com.limyel.blog.common.utils.SlugUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagService tagService;

    @Autowired
    private PostTagService postTagService;

    @Override
    public Post getById(Long id) {
        return postRepository.getOne(id);
    }

    @Override
    public PageUtil pageInHome(Long pageNum, Long pageSize) {
        Page<PostInHomeVO> page = new Page<>(pageNum, pageSize);

        Page<PostInHomeVO> postPage = this.postMapper.selectInHome(page);

        return new PageUtil(postPage);
    }

    @Override
    public int save(PostDTO vo) {
        Post post = BeanUtil.copy(vo, Post.class);
        post.setSlug(SlugUtil.generate(vo.getTitle()));

        if (!validateTags(vo.getTagIdList())) {
            throw new ApiException(20001);
        }
        int result = postMapper.insert(post);

        vo.getTagIdList().forEach(tagId -> {
            PostTag postTag = new PostTag();
            postTag.setPostId(post.getId());
            postTag.setTagId(tagId);
            postTagService.save(postTag);
        });

        return result;
    }

    @Override
    public PostDetailVO getDetailById(Long id) {
        Optional<Post> optionalPost = Optional.of(postMapper.selectById(id));
        Post post = optionalPost.orElseThrow(() -> new ApiException(10001));
        PostDetailVO postDetail = BeanUtil.copy(post, PostDetailVO.class);
        List<Long> tagIdList = tagService.listByPostId(post.getId()).stream()
                .map(TagInPostVO::getId)
                .collect(Collectors.toList());
        postDetail.setTagIdList(tagIdList);
        return postDetail;
    }

    @Override
    public PostDetailVO getDetailBySlug(String slug) {
        QueryWrapper<Post> wrapper = new QueryWrapper<>();
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
        IPage<PostInArchiveVO> postPage = postMapper.selectByTagId(page, tag.getId());

        return new PageUtil(postPage);
    }

    @Override
    public int update(Long id, PostDTO postDTO) {
        if (ObjectUtils.isNotEmpty(postDTO.getTagIdList()) && !validateTags(postDTO.getTagIdList())) {
            throw new ApiException(20001);
        }

        Post post = BeanUtil.copy(postDTO, Post.class);
        post.setId(id);

        return postMapper.updateById(post);
    }

    @Override
    public int delete(Long id) {
        Optional<Post> post = Optional.of(postMapper.selectById(id));
        return postMapper.deleteById(post.orElseThrow(() -> new ApiException(10001)));
    }

    @Override
    public AboutVO getAbout() {
        LambdaQueryWrapper<Post> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Post::getType, Post.Type.about);
        Post post = postMapper.selectOne(wrapper);
        return BeanUtil.copy(post, AboutVO.class);
    }

    @Override
    public PageUtil pageWeekly(Page<Post> page) {
        LambdaQueryWrapper<Post> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Post::getType, Post.Type.weekly);
        IPage<Post> postPage = postMapper.selectPage(page, wrapper);
        List<PostInArchiveVO> result = postPage.getRecords().stream()
                .map(post -> BeanUtil.copy(post, PostInArchiveVO.class))
                .collect(Collectors.toList());
        return new PageUtil(result, postPage);
    }

    /**
     * 验证标签是否正确
     * @param idList
     * @return
     */
    private boolean validateTags(List<Long> idList) {
        return tagService.countByIds(idList) == idList.size();
    }
}
