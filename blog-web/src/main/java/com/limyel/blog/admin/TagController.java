package com.limyel.blog.admin;

import com.github.pagehelper.PageInfo;
import com.limyel.blog.common.Response;
import com.limyel.blog.entity.Tag;
import com.limyel.blog.entity.vo.TagVO;
import com.limyel.blog.service.TagService;
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

@Api(tags = "Admin 标签")
@RestController("adminTagController")
@RequestMapping("/admin/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @ApiOperation(value = "保存", httpMethod = "POST")
    @PostMapping
    public Response save(
            @RequestBody TagVO vo
    ) {
        Tag tag = new Tag();
        tag.setName(vo.getName());
        tagService.save(tag);

        return Response.success();
    }

    @ApiOperation(value = "删除", httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    public Response delete(
            @PathVariable("id") Long id
    ) {
        Tag tag = tagService.getById(id);
        if (tag == null) {
            return Response.notFound();
        }
        tagService.delete(tag);
        return Response.success();
    }

    @ApiOperation(value = "修改", httpMethod = "PUT")
    @PutMapping("/{id}")
    public Response update(
            @PathVariable("id") Long id,
            @RequestBody TagVO vo
    ) {
        Tag tag = tagService.getById(id);
        if (tag == null) {
            return Response.notFound();
        }
        tagService.update(tag, vo);
        return Response.success();
    }

    @ApiOperation(value = "列表", httpMethod = "GET")
    @GetMapping
    public Response list(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize
    ) {
        PageInfo<Tag> page = tagService.page(pageNum, pageSize);
        return Response.success(page);
    }
}
