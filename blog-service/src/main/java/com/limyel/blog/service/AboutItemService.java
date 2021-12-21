package com.limyel.blog.service;

import com.limyel.blog.entity.AboutItem;
import com.limyel.blog.entity.vo.AboutItemVO;

import java.util.List;

public interface AboutItemService {

    List<AboutItem> listByAboutId(Long aboutId);

    int save(AboutItemVO vo);

    AboutItem getById(Long id);

    int delete(AboutItem aboutItem);

}
