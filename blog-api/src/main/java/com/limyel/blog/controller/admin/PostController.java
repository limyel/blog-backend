package com.limyel.blog.controller.admin;

import com.limyel.blog.common.api.Response;
import com.limyel.blog.common.utils.PageUtil;
import com.limyel.blog.vo.PostDetailVO;
import com.limyel.blog.dto.PostDTO;
import com.limyel.blog.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(tags = "Admin 文章")
@Slf4j
@RestController("adminPostController")
@RequestMapping("admin/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @ModelAttribute
    public void testttt(HttpServletRequest request, HttpServletResponse response) {
        log.info(request.getMethod());
    }

    @ApiOperation(value = "列表", httpMethod = "GET")
    @GetMapping
    public Response<PageUtil> list(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Long pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Long pageSize
    ) {
        return Response.success(postService.pageInHome(pageNum, pageSize));
    }

    @ApiOperation(value = "新增", httpMethod = "POST")
    @PostMapping
    public Response save(
            @RequestBody PostDTO vo
    ) {
        postService.save(vo);
        return Response.success();
    }

    @ApiOperation(value = "详情", httpMethod = "GET")
    @GetMapping("/{id}")
    public Response getDetail(
            @PathVariable("id") Long id
    ) {
        PostDetailVO postDetail = postService.getDetailById(id);
        return Response.success(postDetail);
    }

    @ApiOperation(value = "修改", httpMethod = "PUT")
    @PutMapping("/{id}")
    public Response update(
            @PathVariable(value = "id") Long id,
            @RequestBody PostDTO vo
    ) {
        postService.update(id, vo);
        return Response.success();
    }

    @ApiOperation(value = "删除", httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    public Response delete(
            @PathVariable("id") Long id
    ) {
        postService.delete(id);
        return Response.success();
    }
}
