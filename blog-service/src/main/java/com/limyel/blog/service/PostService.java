package com.limyel.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.limyel.blog.common.utils.PageUtil;
import com.limyel.blog.entity.Post;
import com.limyel.blog.vo.AboutVO;
import com.limyel.blog.vo.PostDetailVO;
import com.limyel.blog.vo.PostInArchiveVO;
import com.limyel.blog.dto.PostDTO;

import java.util.List;

public interface PostService extends IService<Post> {

    Post getById(Long id);

    PageUtil pageInHome(Long pageNum, Long pageSize);

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

    PageUtil pageByTag(String slug, Long pageNum, Long pageSize);

    int update(Long id, PostDTO postDTO);

    int delete(Long id);

    AboutVO getAbout();

    PageUtil pageWeekly(Page<Post> page);
}
