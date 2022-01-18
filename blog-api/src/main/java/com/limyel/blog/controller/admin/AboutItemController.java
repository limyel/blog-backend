package com.limyel.blog.controller.admin;

import com.limyel.blog.common.Response;
import com.limyel.blog.entity.AboutItem;
import com.limyel.blog.entity.dto.AboutItemDTO;
import com.limyel.blog.service.AboutItemService;
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

@Api(tags = "Admin 关于item")
@RestController("adminAboutItemController")
@RequestMapping("/admin/about-items")
public class AboutItemController {

    @Autowired
    private AboutItemService aboutItemService;


    @ApiOperation(value = "添加 item", httpMethod = "POST")
    @PostMapping
    public Response save(
            @RequestBody AboutItemDTO vo
    ) {
        aboutItemService.save(vo);
        return Response.success();
    }

    @ApiOperation(value = "删除 item", httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    public Response delete(
            @PathVariable("id") Long id
    ) {
        AboutItem aboutItem = aboutItemService.getById(id);
        if (aboutItem == null) {
            return Response.notFound();
        }
        aboutItemService.delete(aboutItem);
        return Response.success();
    }

    @ApiOperation(value = "列表", httpMethod = "GET")
    @GetMapping("/about/{id}")
    public Response list(
            @PathVariable Long id
    ) {
        List<AboutItem> aboutItems = aboutItemService.listByAboutId(id);
        return Response.success(aboutItems);
    }

    @ApiOperation(value = "修改", httpMethod = "PUT")
    @PutMapping("/{id}")
    public Response update(
            @PathVariable Long id,
            @RequestBody AboutItemDTO aboutItemDTO
    ) {
        AboutItem aboutItem = aboutItemService.getById(id);
        if (aboutItem == null) {
            return Response.notFound();
        }
        BeanUtil.cover(aboutItemDTO, aboutItem);
        aboutItemService.update(aboutItem);
        return Response.success();
    }

}
