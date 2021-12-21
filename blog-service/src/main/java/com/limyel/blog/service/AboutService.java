package com.limyel.blog.service;

import com.github.pagehelper.PageInfo;
import com.limyel.blog.entity.About;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.entity.dto.AboutDetail;

import java.util.List;

public interface AboutService {

    List<AboutDetail> listDetail();

    int save(About about);

    About getById(Long id);

    int delete(About about);

    int update(About about);

    PageInfo<About> page(int pageNum, int pageSize);

    AboutDetail getDetailById(Long id);
}
