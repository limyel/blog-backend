package com.limyel.blog.search.repository;

import com.limyel.blog.search.entity.EsPost;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsPostRepository extends ElasticsearchRepository<EsPost, Long> {
}
