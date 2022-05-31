package com.limyel.blog.dao;

import com.limyel.blog.entity.Tag;
import com.limyel.blog.vo.TagDetailVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findTagBySlug(String slug);

    List<Tag> findTagsByOrderByCreateTimeDesc();
}