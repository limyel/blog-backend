package com.limyel.blog.service.impl;

import com.limyel.blog.entity.dto.AboutDetail;
import com.limyel.blog.dao.AboutMapper;
import com.limyel.blog.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutServiceImpl implements AboutService {

    @Autowired
    private AboutMapper aboutMapper;

    @Override
    public List<AboutDetail> listDetail() {
        return aboutMapper.selectDetail();
    }

}
