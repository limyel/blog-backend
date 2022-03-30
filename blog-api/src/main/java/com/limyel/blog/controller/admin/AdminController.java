package com.limyel.blog.controller.admin;

import com.limyel.blog.core.Response;
import com.limyel.blog.entity.Admin;
import com.limyel.blog.dto.AdminLoginDTO;
import com.limyel.blog.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Admin 管理员")
@RestController("adminAdminController")
@RequestMapping("/admin/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "登录", httpMethod = "POST")
    @PostMapping("/login")
    public Response login(
            @RequestBody AdminLoginDTO adminLoginDTO
    ) {
        Admin admin = adminService.getByName(adminLoginDTO.getName());
        if (admin == null) {
            return Response.notFound();
        }
        String token = adminService.login(admin, adminLoginDTO);
        if (token != null) {
            return Response.success(token);
        }
        return Response.failedMsg("用户名或密码错误");
    }

}
