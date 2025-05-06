package com.example.yue.controller;

import com.example.yue.entity.User;
import com.example.yue.entity.dto.UserDTO;
import com.example.yue.service.UserService;
import com.example.yue.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController // 接口方法返回对象 转成json文本
@RequestMapping("/user")  // 映射路径 localhost:8088/user
public class UserController {

    @Autowired
    private UserService userService;

//增加 Validated校验参数
    @PostMapping
    public Result<User> addUser(@Validated @RequestBody UserDTO user){
        User newUser = userService.addUser(user);
        return Result.success(newUser);
    }
//查询
    @GetMapping("/{userId}")
    public Result<User> getUser(@PathVariable("userId") Integer userId){
        User user = userService.getUser(userId);
        return Result.success(user);
    }

//修改
    @PutMapping
    public Result<User> updateUser(@RequestBody UserDTO user){
        User newUser = userService.updateUser(user);
        return Result.success(newUser);
    }
//删除
    @DeleteMapping("/{userId}")
    public Result<String> deleteUser(@PathVariable Integer userId){
        userService.deleteUser(userId);
        return Result.success("删除成功");
    }

}
