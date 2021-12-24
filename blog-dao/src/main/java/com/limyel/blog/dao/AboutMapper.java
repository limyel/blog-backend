package com.limyel.blog.dao;

import com.limyel.blog.entity.About;
import com.limyel.blog.entity.vo.AboutDetailVO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AboutMapper extends Mapper<About> {

    List<AboutDetailVO> selectDetail();

}