package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public String home() {
        return "Hello, World!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }
    // 接收name参数
    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {
        System.out.println("name: " + name);
        return "Hello, " + name + "!";
    }

    // 登录接口
    @PostMapping("/login")
    public String login(String username, String password) {
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        return "Login Success!";
    }
}
