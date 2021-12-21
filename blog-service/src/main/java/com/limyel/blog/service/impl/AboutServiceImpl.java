package com.limyel.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.limyel.blog.common.exception.BlogException;
import com.limyel.blog.entity.About;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.entity.dto.AboutDetail;
import com.limyel.blog.dao.AboutMapper;
import com.limyel.blog.service.AboutItemService;
import com.limyel.blog.service.AboutService;
import com.limyel.blog.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutServiceImpl implements AboutService {

    @Autowired
    private AboutMapper aboutMapper;

    @Autowired
    private AboutItemService aboutItemService;

    @Override
    public List<AboutDetail> listDetail() {
        return aboutMapper.selectDetail();
    }

    @Override
    public int save(About about) {
        return aboutMapper.insertSelective(about);
    }

    @Override
    public About getById(Long id) {
        return aboutMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(About about) {
        about.setDeleted(true);
        return aboutMapper.updateByPrimaryKey(about);
    }

    @Override
    public int update(About about) {
        return aboutMapper.updateByPrimaryKey(about);
    }

    @Override
    public PageInfo<About> page(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<About> abouts = aboutMapper.selectAll();
        return new PageInfo<>(abouts);
    }

    @Override
    public AboutDetail getDetailById(Long id) {
        About about = aboutMapper.selectByPrimaryKey(id);
        if (about == null) {
            throw new BlogException("About not found");
        }
        AboutDetail aboutDetail = BeanUtil.copy(about, AboutDetail.class);
        aboutDetail.setItems(aboutItemService.listByAboutId(about.getId()));
        return aboutDetail;
    }

}
