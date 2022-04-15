package com.limyel.blog.service.impl;

import com.limyel.blog.entity.EsPost;
import com.limyel.blog.service.EsPostService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EsPostServiceImpl implements EsPostService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    public Page<EsPost> findAll(String keyword, Integer page, Integer size) {
        log.info(restHighLevelClient.toString());
        return null;
    }
}
