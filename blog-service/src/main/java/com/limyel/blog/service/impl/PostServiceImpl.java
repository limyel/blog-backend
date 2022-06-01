package com.limyel.blog.service.impl;

import com.limyel.blog.common.api.Paging;
import com.limyel.blog.dao.PostRepository;
import com.limyel.blog.dto.PostDetailDTO;
import com.limyel.blog.dto.PostPureDTO;
import com.limyel.blog.entity.Post;
import com.limyel.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Paging<PostPureDTO> page(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Post> page = postRepository.findPostsByOrderByCreateTimeDesc(pageable);
        List<PostPureDTO> result = page.getContent().stream().map(PostPureDTO::new).collect(Collectors.toList());
        return new Paging<>(page, result);
    }

    @Override
    public PostDetailDTO getBySlug(String slug) {
        Post post = postRepository.findPostBySlug(slug);
        return new PostDetailDTO(post);
    }
}
