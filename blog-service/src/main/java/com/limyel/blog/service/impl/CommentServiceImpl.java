package com.limyel.blog.service.impl;

import com.limyel.blog.dao.CommentMapper;
import com.limyel.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author limyel
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

}
