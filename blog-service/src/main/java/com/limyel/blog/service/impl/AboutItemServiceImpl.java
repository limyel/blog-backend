package com.limyel.blog.service.impl;

import com.limyel.blog.common.exception.BlogException;
import com.limyel.blog.dao.AboutItemMapper;
import com.limyel.blog.entity.About;
import com.limyel.blog.entity.AboutItem;
import com.limyel.blog.entity.dto.AboutItemDTO;
import com.limyel.blog.service.AboutItemService;
import com.limyel.blog.service.AboutService;
import com.limyel.blog.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author limyel
 */
@Service
public class AboutItemServiceImpl implements AboutItemService {

    @Autowired
    private AboutItemMapper aboutItemMapper;

    @Autowired
    private AboutService aboutService;

    @Override
    public List<AboutItem> listByAboutId(Long aboutId) {
        return aboutItemMapper.selectByAboutId(aboutId);
    }

    @Override
    public int save(AboutItemDTO vo) {
        About about = aboutService.getById(vo.getAboutId());
        if (about == null) {
            throw new BlogException("About not found");
        }
        AboutItem aboutItem = BeanUtil.copy(vo, AboutItem.class);
        return aboutItemMapper.insertSelective(aboutItem);
    }

    @Override
    public AboutItem getById(Long id) {
        return aboutItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(AboutItem aboutItem) {
        aboutItem.setDeleted(true);
        return aboutItemMapper.updateByPrimaryKey(aboutItem);
    }

    @Override
    public int update(AboutItem aboutItem) {
        return aboutItemMapper.updateByPrimaryKey(aboutItem);
    }

    @Override
    public int deleteByAboutId(Long aboutId) {
        return aboutItemMapper.deleteByAboutId(aboutId);
    }


}
