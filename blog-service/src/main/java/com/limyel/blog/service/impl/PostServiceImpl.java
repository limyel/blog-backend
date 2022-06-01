package com.limyel.blog.service.impl;

import com.limyel.blog.common.api.Paging;
import com.limyel.blog.common.exception.ApiException;
import com.limyel.blog.dao.PostRepository;
import com.limyel.blog.dao.TagRepository;
import com.limyel.blog.dto.PostDetailDTO;
import com.limyel.blog.dto.PostPureDTO;
import com.limyel.blog.entity.Post;
import com.limyel.blog.entity.Tag;
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

    @Autowired
    private TagRepository tagRepository;

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

    @Override
    public List<PostPureDTO> listByTag(String tagSlug) {
        Tag tag = tagRepository.findTagBySlug(tagSlug).orElseThrow(() -> new ApiException(20001));
        List<Post> postList = postRepository.findPostsByTagListContains(tag);
        List<PostPureDTO> result = postList.stream().map(PostPureDTO::new).collect(Collectors.toList());
        return result;
    }

    @Override
    public PostDetailDTO getAbout() {
        Tag tag = tagRepository.findTagBySlug("about").orElseThrow(() -> new ApiException(20001));
        Post post = postRepository.findFirstByTagListContains(tag);
        return new PostDetailDTO(post);
    }
}
