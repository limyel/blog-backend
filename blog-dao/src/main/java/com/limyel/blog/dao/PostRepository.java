package com.limyel.blog.dao;

import com.limyel.blog.dto.PostDetailDTO;
import com.limyel.blog.entity.Post;
import com.limyel.blog.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findPostsByOrderByCreateTimeDesc(Pageable pageable);

    Post findPostBySlug(String slug);

    Page<Post> findPostsByTagListContains(Tag tag, Pageable pageable);

    Post findFirstByTagListContains(Tag tag);

}
