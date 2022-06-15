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
import com.limyel.blog.vo.HomeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagRepository tagRepository;

    @Override
    public HomeVO pageWithYear(String tagSlug, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Post> page;
        if (StringUtils.isEmpty(tagSlug)) {
            page = postRepository.findPostsByOrderByCreateTimeDesc(pageable);
        } else {
            Tag tag = tagRepository.findTagBySlug(tagSlug).orElseThrow(() -> new ApiException(20001));
            page = postRepository.findPostsByTagListContainsOrderByCreateTimeDesc(tag, pageable);
        }
        List<PostPureDTO> postList = page.getContent().stream().map(PostPureDTO::new).collect(Collectors.toList());
        Map<Integer, List<PostPureDTO>> result = new HashMap<>();
        postList.forEach(postPureDTO -> {
            int year = postPureDTO.getCreateTime().getYear();
            if (ObjectUtils.isEmpty(result.get(year))) {
                result.put(year, new ArrayList<>());
            }
            result.get(year).add(postPureDTO);
        });

        HomeVO homeVO = new HomeVO(page);
        homeVO.setResult(result);
        return homeVO;
    }

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
    public PostDetailDTO getAbout() {
        Post post = postRepository.findFirstByType(Post.Type.about);
        return new PostDetailDTO(post);
    }
}
