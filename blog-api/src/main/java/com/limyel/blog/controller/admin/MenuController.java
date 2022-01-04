package com.limyel.blog.controller.admin;

import com.limyel.blog.common.Response;
import com.limyel.blog.entity.Menu;
import com.limyel.blog.entity.dto.MenuDTO;
import com.limyel.blog.entity.vo.MenuVO;
import com.limyel.blog.service.MenuService;
import com.limyel.blog.utils.BeanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Admin 菜单")
@RestController("adminMenuController")
@RequestMapping("/admin/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "列表", httpMethod = "GET")
    @GetMapping
    public Response list() {
        List<MenuVO> result = menuService.list();
        return Response.success(result);
    }

    @ApiOperation(value = "新增", httpMethod = "POST")
    @PostMapping
    public Response save(
            @RequestBody MenuDTO menuDTO
    ) {
        Menu menu = BeanUtil.copy(menuDTO, Menu.class);
        if (menuDTO.getParentId() != null) {
            Menu parentMenu = menuService.getParentById(menuDTO.getParentId());
            if (parentMenu == null) {
                return Response.failed("父菜单不存在");
            }
        }
        menuService.save(menu);
        return Response.success();
    }

    @ApiOperation(value = "删除", httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    public Response delete(
            @PathVariable Long id
    ) {
        Menu menu = menuService.getById(id);
        if (menu == null) {
            return Response.notFound();
        }
        menuService.delete(menu);
        return Response.success();
    }

    @ApiOperation(value = "修改", httpMethod = "PUT")
    @PutMapping("/{id}")
    public Response update(
            @PathVariable Long id,
            @RequestBody MenuDTO menuDTO
    ) {
        Menu menu = menuService.getById(id);
        if (menu == null) {
            return Response.notFound();
        }
        menuService.update(menu, menuDTO);
        return Response.success();
    }

    @ApiOperation(value = "详情", httpMethod = "GET")
    @GetMapping("/{id}")
    public Response detail(
            @PathVariable Long id
    ) {
        Menu menu = menuService.getById(id);
        if (menu == null) {
            return Response.notFound();
        }
        MenuVO result = menuService.getDetail(menu);

        return Response.success(result);
    }

}
