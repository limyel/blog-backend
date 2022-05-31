package com.limyel.blog.service.impl;

import com.limyel.blog.common.api.Paging;
import com.limyel.blog.common.exception.ApiException;
import com.limyel.blog.dao.PostRepository;
import com.limyel.blog.entity.Post;
import com.limyel.blog.service.PostService;
import com.limyel.blog.vo.PostDetailVO;
import com.limyel.blog.vo.PostPureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Paging<PostPureVO> pageInHome(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Post> page = postRepository.findPostsByOrderByCreateTimeDesc(pageable);
        return new Paging<>(page, PostPureVO.class);
    }

    @Override
    public PostDetailVO getDetail(String slug) {
        Post post = postRepository.findPostBySlug(slug)
                .orElseThrow(() -> new ApiException(10001));
        return new PostDetailVO(post);
    }

    @Override
    public PostDetailVO getAbout() {
        return this.getDetail("about");
    }
}
