package com.limyel.blog.service;

import com.github.pagehelper.PageInfo;
import com.limyel.blog.entity.Post;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.vo.PostDetailVO;
import com.limyel.blog.vo.PostInArchiveVO;
import com.limyel.blog.vo.PostInHomeVO;
import com.limyel.blog.dto.PostDTO;

import java.util.List;

public interface PostService {

    Post getById(Long id);

    PageInfo<PostInHomeVO> pageInHome(int pageNum, int pageSize);

    /**
     * 保存
     * @param vo
     * @return
     */
    int save(PostDTO vo);

    PostDetailVO getDetailById(Long id);

    PostDetailVO getDetailBySlug(String slug);

    List<Integer> listYear();

    List<PostInArchiveVO> listInArchive(int year);

    List<PostInArchiveVO> listHot();

    PageInfo<PostInArchiveVO> pageInTag(Tag tag, int pageNum, int pageSize);

    int update(Post post, PostDTO vo);

    int delete(Post post);
}
