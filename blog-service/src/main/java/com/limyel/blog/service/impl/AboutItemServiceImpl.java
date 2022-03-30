package com.limyel.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.limyel.blog.common.exception.BlogException;
import com.limyel.blog.dao.AboutItemMapper;
import com.limyel.blog.entity.About;
import com.limyel.blog.entity.AboutItem;
import com.limyel.blog.dto.AboutItemDTO;
import com.limyel.blog.service.AboutItemService;
import com.limyel.blog.service.AboutService;
import com.limyel.blog.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author limyel
 */
@Service
public class AboutItemServiceImpl extends ServiceImpl<AboutItemMapper, AboutItem> implements AboutItemService {

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
        return aboutItemMapper.insert(aboutItem);
    }

    @Override
    public AboutItem getById(Long id) {
        return aboutItemMapper.selectById(id);
    }

    @Override
    public int deleteById(Long id) {
        AboutItem aboutItem = aboutItemMapper.selectById(id);
        if (aboutItem == null) {

        }
        return aboutItemMapper.deleteById(id);
    }

    @Override
    public int update(AboutItem aboutItem) {
        return aboutItemMapper.updateById(aboutItem);
    }

    @Override
    public int deleteByAboutId(Long aboutId) {
        return aboutItemMapper.deleteById(aboutId);
    }


}
