package com.limyel.blog.dao;

import com.limyel.blog.entity.About;
import com.limyel.blog.entity.Admin;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author limyel
 */
@Repository
public interface AdminMapper extends Mapper<Admin> {
}