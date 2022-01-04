package com.limyel.blog.dao;

import com.limyel.blog.entity.Menu;
import com.limyel.blog.entity.vo.MenuVO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface MenuMapper extends Mapper<Menu> {

    List<MenuVO> selectVO();

    List<MenuVO> selectSubMenu(Long parentId);

    int deleteByParentId(Long parentId);

}