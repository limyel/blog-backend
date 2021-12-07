package com.limyel.blog.mapper;

import com.limyel.blog.entity.Post;
import com.limyel.blog.entity.dto.PostDetail;
import com.limyel.blog.entity.dto.PostInHome;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface PostMapper extends Mapper<Post> {

    List<PostInHome> selectInHome();

}