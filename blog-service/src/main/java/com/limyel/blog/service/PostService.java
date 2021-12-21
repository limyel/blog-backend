package com.limyel.blog.service;

import com.github.pagehelper.PageInfo;
import com.limyel.blog.entity.Post;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.entity.dto.PostDetail;
import com.limyel.blog.entity.dto.PostInArchive;
import com.limyel.blog.entity.dto.PostInHome;
import com.limyel.blog.entity.vo.PostVO;

import java.util.List;

public interface PostService {

    Post getById(Long id);

    PageInfo<PostInHome> pageInHome(int pageNum, int pageSize);

    int save(PostVO vo);

    PostDetail getDetailById(Long id);

    PostDetail getDetailBySlug(String slug);

    List<Integer> listYear();

    List<PostInArchive> listInArchive(int year);

    List<PostInArchive> listHot();

    PageInfo<PostInArchive> pageInTag(Tag tag, int pageNum, int pageSize);

    int update(Post post, PostVO vo);

    int delete(Post post);
}
