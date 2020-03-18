package com.example.zt.controller;

import com.example.zt.common.SzpJsonResult;
import com.example.zt.pojo.User;
import com.example.zt.service.UserService;
import com.example.zt.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: zlp
 * Date: 2020-02-09 23:09
 * Description:用户注册API
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //用户注册
    @PostMapping("user/register")
    public SzpJsonResult<Integer>userRegister(@RequestBody User user){
        return SzpJsonResult.ok(userService.userRegister(user));
    }

    //用户登录
    @GetMapping("user/login")
    public SzpJsonResult<User> userLogin(@RequestParam(value = "userName") String userName,@RequestParam(value = "password") String password){
        return SzpJsonResult.ok(userService.userLogin(userName,password));
    }

    //修改用户信息
    @PostMapping("alter/userInfo")
    public SzpJsonResult<Integer> alterUserInfo(@RequestBody User user){
        User currentUser = SessionUtil.getUser();
        if (null == currentUser) {
            return SzpJsonResult.errorException("请先登录");
        }
        return SzpJsonResult.ok(userService.alertUserInfo(user));
    }
}
