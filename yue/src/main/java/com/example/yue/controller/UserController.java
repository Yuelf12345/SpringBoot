package com.example.yue.controller;

import com.example.yue.entity.User;
import com.example.yue.entity.dto.UserDTO;
import com.example.yue.service.UserService;
import com.example.yue.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController // 接口方法返回对象 转成json文本
@RequestMapping("/user")  // 映射路径 localhost:8088/user
public class UserController {

    @Autowired
    private UserService userService;

//增加
    @PostMapping
    public Result<User> addUser(@RequestBody UserDTO user){
        User newUser = userService.addUser(user);
        return Result.success(newUser);
    }
//查询 @GetMapping
//修改 @PutMapping
//删除 @DeleteMapping

}
