package com.limyel.blog.controller.admin;

import com.limyel.blog.common.api.Response;
import com.limyel.blog.entity.User;
import com.limyel.blog.dto.AdminLoginDTO;
import com.limyel.blog.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author limyel
 */
@Api(tags = "Admin 用户")
@RestController
@RequestMapping("/admin/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录", httpMethod = "POST")
    @PostMapping("/login")
    public Response login(
            @RequestBody AdminLoginDTO userLoginDTO
    ) {
        User user = userService.getByInfo(userLoginDTO.getName(), null);
        if (user == null) {
            return Response.notFound();
        }
        String token = userService.login(user, userLoginDTO);
        return null;
    }

}
