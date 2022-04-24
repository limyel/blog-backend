package com.limyel.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.common.utils.PageUtil;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.vo.TagDetailVO;
import com.limyel.blog.vo.TagInPostVO;
import com.limyel.blog.dao.TagMapper;
import com.limyel.blog.dto.TagDTO;
import com.limyel.blog.service.TagService;
import com.limyel.blog.common.utils.BeanUtil;
import com.limyel.blog.common.utils.SlugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public int save(Tag tag) {
        tag.setSlug(SlugUtil.generate(tag.getName()));
        return tagMapper.insert(tag);
    }

    @Override
    public List<TagInPostVO> listByPostId(Long postId) {
        return tagMapper.selectByPostId(postId);
    }

    @Override
    public List<TagDetailVO> listDetail() {
        return tagMapper.selectDetail();
    }

    @Override
    public Tag getBySlug(String slug) {
        QueryWrapper<Tag> wrapper = new QueryWrapper<>();
        wrapper.eq("slug", slug);
        Optional<Tag> tag = Optional.of(tagMapper.selectOne(wrapper));
        // todo not found
        return tag.orElseThrow(RuntimeException::new);
    }

    @Override
    public long countByIds(List<Long> ids) {
        if (ids == null || ids.size() == 0) {
            return 0;
        }
        QueryWrapper<Tag> wrapper = Wrappers.query();
        wrapper.in("id", ids);
        return tagMapper.selectCount(wrapper);
    }

    @Override
    public Tag getById(Long id) {
        return tagMapper.selectById(id);
    }

    @Override
    public int delete(Long id) {
        // todo not found
        return tagMapper.deleteById(id);
    }

    @Override
    public int update(Tag tag, TagDTO vo) {
        BeanUtil.cover(vo, tag);
        tag.setSlug(SlugUtil.generate(vo.getName()));
        return tagMapper.updateById(tag);
    }

    @Override
    public PageUtil page(Long pageNum, Long pageSize) {
        Page<Tag> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Tag> wrapper = new QueryWrapper<>();
        wrapper.eq("deleted", false);
        Page<Tag> tagPage = tagMapper.selectPage(page, wrapper);
        return new PageUtil(tagPage);
    }
}
