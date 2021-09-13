package com.hua.controller;


import com.hua.common.lang.Result;
import com.hua.entity.User;
import com.hua.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hua
 * @since 2021-08-12
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
// 没有问题，可以正常运行
    @RequiresAuthentication
    @GetMapping("/index")
    public Result index() {
        User user = userService.getById(1L);
        return Result.success(user);
    }

// 有问题，无法接收user Validated用于检查是否符合规则，RequestBody用于接收user
    @PostMapping("/save")
    public Result save(@Validated @RequestBody User user) {
        return Result.success(user);
    }
}
