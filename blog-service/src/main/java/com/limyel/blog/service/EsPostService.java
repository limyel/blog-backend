package com.limyel.blog.service;


import com.limyel.blog.entity.EsPost;
import org.springframework.data.domain.Page;

public interface EsPostService {

    Page<EsPost> findAll(String keyword, Integer page, Integer size);

}
