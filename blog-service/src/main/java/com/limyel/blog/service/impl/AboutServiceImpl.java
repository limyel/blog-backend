package com.limyel.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.limyel.blog.common.exception.BlogException;
import com.limyel.blog.core.util.PageUtil;
import com.limyel.blog.entity.About;
import com.limyel.blog.vo.AboutDetailVO;
import com.limyel.blog.dao.AboutMapper;
import com.limyel.blog.service.AboutItemService;
import com.limyel.blog.service.AboutService;
import com.limyel.blog.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author limyel
 */
@Service
public class AboutServiceImpl extends ServiceImpl<AboutMapper, About> implements AboutService {

    @Autowired
    private AboutMapper aboutMapper;

    @Autowired
    private AboutItemService aboutItemService;

    @Override
    public List<AboutDetailVO> listDetail() {
        // todo 用 Stream 改造
        List<About> aboutList = this.aboutMapper.selectList(null);
        List<AboutDetailVO> result = new ArrayList<>();
        for (About about: aboutList) {
            AboutDetailVO aboutDetailVO = BeanUtil.copy(about, AboutDetailVO.class);
            aboutDetailVO.setItems(this.aboutItemService.listByAboutId(about.getId()));
            result.add(aboutDetailVO);
        }
        return result;
    }

    @Override
    public int saveAbout(About about) {
        return aboutMapper.insert(about);
    }

    @Override
    public About getById(Long id) {
        return aboutMapper.selectById(id);
    }

    @Override
    public int delete(Long id) {
        About about = this.getById(id);
        if (about == null) {
            // todo not found
        }
        aboutItemService.deleteByAboutId(id);
        return aboutMapper.deleteById(id);
    }

    @Override
    public int update(About about) {
        return aboutMapper.updateById(about);
    }

    @Override
    public PageUtil page(Long pageNum, Long pageSize) {
        Page<About> page = new Page<>(pageNum, pageSize);
        QueryWrapper<About> wrapper = new QueryWrapper<>();
        Page<About> aboutPage = aboutMapper.selectPage(page, wrapper);
        return new PageUtil(aboutPage);
    }

    @Override
    public AboutDetailVO getDetailById(Long id) {
        About about = aboutMapper.selectById(id);
        if (about == null) {
            throw new BlogException("About not found");
        }
        AboutDetailVO aboutDetail = BeanUtil.copy(about, AboutDetailVO.class);
        aboutDetail.setItems(aboutItemService.listByAboutId(about.getId()));
        return aboutDetail;
    }

}
