package com.limyel.blog.dao;

import com.limyel.blog.entity.Post;
import com.limyel.blog.vo.PostDetailVO;
import com.limyel.blog.vo.PostPureVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findPostsByOrderByCreateTimeDesc(Pageable pageable);

    Optional<Post> findPostBySlug(String slug);

    @Query("select p from Post p inner join Tag t where t.id = ?1 order by p.createTime desc")
    Optional<Post> findAboutPost(Long tagId);

}