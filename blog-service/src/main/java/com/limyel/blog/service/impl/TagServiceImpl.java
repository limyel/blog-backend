package com.limyel.blog.service.impl;

import com.limyel.blog.common.exception.ApiException;
import com.limyel.blog.common.utils.PageUtil;
import com.limyel.blog.dao.TagRepository;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.vo.TagDetailVO;
import com.limyel.blog.vo.TagInPostVO;
import com.limyel.blog.dto.TagDTO;
import com.limyel.blog.service.TagService;
import com.limyel.blog.common.utils.BeanUtil;
import com.limyel.blog.common.utils.SlugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public void save(Tag tag) {
        tag.setSlug(SlugUtil.generate(tag.getName()));
        tagRepository.save(tag);
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
        Optional<Tag> tag = tagRepository.findTagBySlug(slug);
        return tag.orElseThrow(() -> new ApiException(20001));
    }

    @Override
    public long countByIds(List<Long> idList) {
        if (idList == null || idList.size() == 0) {
            return 0;
        }
        return tagRepository.countTagsByIdIn(idList);
    }

    @Override
    public Tag getById(Long id) {
        return tagRepository.getOne(id);
    }

    @Override
    public int delete(Long id) {
        Optional<Tag> tag = Optional.of(tagMapper.selectById(id));
        return tagMapper.deleteById(tag.orElseThrow(() -> new ApiException(20001)));
    }

    @Override
    public void update(Tag tag, TagDTO vo) {
        BeanUtil.cover(vo, tag);
        tag.setSlug(SlugUtil.generate(vo.getName()));
        tagRepository.save(tag);
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
