package com.limyel.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.entity.vo.TagDetailVO;
import com.limyel.blog.entity.vo.TagInPostVO;
import com.limyel.blog.dao.TagMapper;
import com.limyel.blog.entity.dto.TagDTO;
import com.limyel.blog.service.TagService;
import com.limyel.blog.utils.BeanUtil;
import com.limyel.blog.utils.SlugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public int save(Tag tag) {
        tag.setSlug(SlugUtil.generate(tag.getName()));
        return tagMapper.insertSelective(tag);
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
        Tag record = new Tag();
        record.setSlug(slug);
        Tag tag = tagMapper.selectOne(record);
        return tag;
    }

    @Override
    public int countByIds(List<Long> ids) {
        if (ids == null || ids.size() == 0) {
            return 0;
        }
        return tagMapper.selectCountByIds(ids);
    }

    @Override
    public Tag getById(Long id) {
        return tagMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Tag tag) {
        tag.setDeleted(true);
        return tagMapper.updateByPrimaryKey(tag);
    }

    @Override
    public int update(Tag tag, TagDTO vo) {
        BeanUtil.cover(vo, tag);
        tag.setSlug(SlugUtil.generate(vo.getName()));
        return tagMapper.updateByPrimaryKey(tag);
    }

    @Override
    public PageInfo<Tag> page(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Tag> tags = tagMapper.selectAll();
        return new PageInfo<>(tags);
    }
}
