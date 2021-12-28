package com.limyel.blog.service.impl;

import com.limyel.blog.entity.Post;
import com.limyel.blog.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceImplTest {

    @Autowired
    private PostService postService;

//    @Test
//    public void testInsert() {
//        Post post = new Post();
//        post.setId(10L);
//        post.setContent("hello");
//        post.setTitle("hello");
//        post.setSlug("hello");
//        postService.create(post);
//    }

}
