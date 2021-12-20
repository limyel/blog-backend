package com.limyel.blog.admin;

import com.limyel.blog.common.Response;
import com.limyel.blog.entity.Post;
import com.limyel.blog.entity.dto.PostDetail;
import com.limyel.blog.entity.vo.PostVO;
import com.limyel.blog.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Admin 文章")
@RestController("adminPostController")
@RequestMapping("admin/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @ApiOperation(value = "列表", httpMethod = "GET")
    @GetMapping
    public Response list(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize
    ) {
        return null;
    }

    @ApiOperation(value = "新增", httpMethod = "POST")
    @PostMapping
    public Response save(
            @RequestBody PostVO vo
    ) {
        postService.save(vo);
        return Response.success();
    }

    @ApiOperation(value = "详情", httpMethod = "GET")
    @GetMapping("/{id}")
    public Response getDetail(
            @PathVariable("id") Long id
    ) {
        PostDetail postDetail = postService.getDetailById(id);
        return Response.success(postDetail);
    }

    @ApiOperation(value = "修改", httpMethod = "PUT")
    @PutMapping("/{id}")
    public Response update(
            @PathVariable("id") Long id,
            @RequestBody PostVO vo
    ) {
        Post post = postService.getById(id);
        if (post == null) {
            return Response.notFound();
        }
        postService.update(post, vo);
        return Response.success();
    }

}
