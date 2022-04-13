package com.limyel.blog.controller.admin;

import com.limyel.blog.core.Response;
import com.limyel.blog.core.util.PageUtil;
import com.limyel.blog.entity.About;
import com.limyel.blog.vo.AboutDetailVO;
import com.limyel.blog.dto.AboutDTO;
import com.limyel.blog.service.AboutItemService;
import com.limyel.blog.service.AboutService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Admin 关于")
@RestController("adminAboutController")
@RequestMapping("/admin/abouts")
public class AboutController {

    @Autowired
    private AboutService aboutService;

    @Autowired
    private AboutItemService aboutItemService;

    @ApiOperation(value = "新增", httpMethod = "POST")
    @PostMapping
    public Response save(
            @RequestBody AboutDTO vo
    ) {
        About about = BeanUtil.copy(vo, About.class);
        aboutService.save(about);
        return Response.success();
    }

    @ApiOperation(value = "删除", httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    public Response delete(
            @PathVariable("id") Long id
    ) {
        aboutService.delete(id);
        return Response.success();
    }

    @ApiOperation(value = "修改", httpMethod = "PUT")
    @PutMapping("/{id}")
    public Response update(
            @PathVariable("id") Long id,
            @RequestBody AboutDTO vo
    ) {
        About about = aboutService.getById(id);
        if (about == null) {
            return Response.notFound();
        }
        BeanUtil.cover(vo, about);
        aboutService.update(about);
        return Response.success();
    }

    @ApiOperation(value = "列表", httpMethod = "GET")
    @GetMapping
    public Response<PageUtil> list(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Long pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Long pageSize
    ) {
        return Response.success(aboutService.page(pageNum, pageSize));
    }

    @ApiOperation(value = "详情", httpMethod = "GET")
    @GetMapping("/{id}")
    public Response<AboutDetailVO> getDetail(
            @PathVariable("id") Long id
    ) {
        return Response.success(aboutService.getDetailById(id));
    }

}
