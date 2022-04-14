package com.limyel.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.limyel.blog.entity.About;
import com.limyel.blog.vo.AboutDetailVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AboutMapper extends BaseMapper<About> {

}