package com.limyel.blog.service;

import com.limyel.blog.entity.Menu;
import com.limyel.blog.entity.dto.MenuDTO;
import com.limyel.blog.entity.vo.MenuVO;

import java.util.List;

public interface MenuService {

    List<MenuVO> list();

    /**
     * 通过 id 获取父菜单
     * @param id
     * @return
     */
    Menu getParentById(Long id);

    int save(Menu menu);

    Menu getById(Long id);

    int delete(Menu menu);

    int update(Menu menu, MenuDTO menuDTO);

    MenuVO getDetail(Menu menu);
}
