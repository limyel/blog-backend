package com.limyel.blog.service.impl;

import com.limyel.blog.dao.MenuMapper;
import com.limyel.blog.entity.Menu;
import com.limyel.blog.entity.dto.MenuDTO;
import com.limyel.blog.entity.vo.MenuVO;
import com.limyel.blog.service.MenuService;
import com.limyel.blog.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuVO> list() {
        return menuMapper.selectVO();
    }

    @Override
    public Menu getParentById(Long id) {
        Menu menu = menuMapper.selectByPrimaryKey(id);
        // 是否为空 || 是否为父菜单
        return menu == null || menu.getParentId() != null? null: menu;
    }

    @Override
    public int save(Menu menu) {
        return menuMapper.insertSelective(menu);
    }

    @Override
    public Menu getById(Long id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Menu menu) {
        if (menu.getParentId() != null) {
            return menuMapper.delete(menu);
        }
        menuMapper.deleteByParentId(menu.getId());
        return menuMapper.delete(menu);
    }

    @Override
    public int update(Menu menu, MenuDTO menuDTO) {
        Menu newMenu = BeanUtil.copy(menuDTO, Menu.class);
        newMenu.setId(menu.getId());
        return menuMapper.updateByPrimaryKeySelective(newMenu);
    }

    @Override
    public MenuVO getDetail(Menu menu) {
        MenuVO result = BeanUtil.copy(menu, MenuVO.class);
        if (menu.getParentId() != null) {
            return result;
        }
        List<MenuVO> subMenus = menuMapper.selectSubMenu(menu.getId());
        result.setSubMenus(subMenus);
        return result;
    }


}
