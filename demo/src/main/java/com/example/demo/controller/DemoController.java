package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Arrays;

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

    // get 接收参数
    @GetMapping("/get1")
    public String get1(@RequestParam String username, String password) {
        return "Hello, " + username + password + "!";
    }

    @GetMapping("/get2/{username}")
    public String get2(@PathVariable String username) {
        System.out.println("username: " + username);
        return "Hello, " + username + "!";
    }

    // post 参数接收实体类
    @PostMapping("/post1")
    public String post1(@RequestBody LoginRequest request) {
        System.out.println("username: " + request.getUsername());
        System.out.println("password: " + request.getPassword());
        return "username：" + request.getUsername() + "\npassword：" + request.getPassword();
    }

    static class LoginRequest {
        private String username;
        private String password;

        // Getters and Setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    // 数组或者集合类JSON参数
    @PostMapping("/post2")
    public String post2(@RequestBody String[] names) {
        Arrays.stream(names).forEach(System.out::println);
        return "成功";
    }

    // map接收
    @PostMapping("/post3")
    public String post3(@RequestBody Map<String, Object> map) {
        map.forEach((k, v) -> System.out.println(k + ":" + v));
        return "成功";
    }
}
