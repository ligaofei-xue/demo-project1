package com.ligaofei.demoproject1.controller;

import com.ligaofei.demoproject1.domain.User;
import com.ligaofei.demoproject1.service.UserService;
import com.ligaofei.demoproject1.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/pub/user")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * form表单形式提交，前端可在Query中拼接参数或在body中添加form表单参数
     * @param pwd
     * @param username
     * @return
     */
    @PostMapping("login")
    public JsonData login(String pwd, String username) {
        System.out.println("username=" + username + " pwd=" + pwd);
        return JsonData.buildSuccess("");
    }

    /**
     * 登录接口
     * json格式提交，务必加@RequestBody
     * 请求协议application/json
     * 例如{"username": "jack","pwd": "123"}
     * @param user
     * @return
     */
    @PostMapping("login2")
    public JsonData login2(@RequestBody User user) {
        System.out.println(user.toString());
        String token = userService.login(user.getUsername(), user.getPwd());
        return token !=null ? JsonData.buildSuccess(token) : JsonData.buildError("账号密码错误");
    }

    /**
     * 列出全部用户
     * @return
     */
    @GetMapping("list")
    public JsonData listUser(){
        return  JsonData.buildSuccess(userService.listUser());
    }
}
