package com.limyel.blog.service;

import com.github.pagehelper.PageInfo;
import com.limyel.blog.entity.About;
import com.limyel.blog.entity.vo.AboutDetailVO;

import java.util.List;

public interface AboutService {

    List<AboutDetailVO> listDetail();

    int save(About about);

    About getById(Long id);

    int delete(About about);

    int update(About about);

    PageInfo<About> page(int pageNum, int pageSize);

    AboutDetailVO getDetailById(Long id);
}
