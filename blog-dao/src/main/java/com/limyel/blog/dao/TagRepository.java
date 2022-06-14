package com.limyel.blog.dao;

import com.limyel.blog.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findTagBySlug(String slug);

    Page<Tag> findTagByOrderByCreateTimeDesc(Pageable pageable);

}
