package com.limyel.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.limyel.blog.entity.AboutItem;
import com.limyel.blog.dto.AboutItemDTO;

import java.util.List;

/**
 * @author limyel
 */
public interface AboutItemService extends IService<AboutItem> {

    /**
     * 根据 关于id 获取 关于items
     * @param aboutId 关于id
     * @return 关于items 列表
     */
    List<AboutItem> listByAboutId(Long aboutId);

    /**
     * 新增
     * @param vo
     * @return
     */
    int save(AboutItemDTO vo); // todo 改为 AboutItem

    AboutItem getById(Long id);

    int delete(AboutItem aboutItem);

    int update(AboutItem aboutItem);

    int deleteByAboutId(Long aboutId);
}
