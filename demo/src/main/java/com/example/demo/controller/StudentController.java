package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.Arrays;
import java.util.List;

import com.example.demo.utils.Result;

@RestController
//@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/list")
    public Result<List<Student>> findAll() {
        System.out.println("/student/list");
        return Result.success(studentService.findAll());
    }

    @GetMapping("/student/{id}")
    public Result<Student> findById(@PathVariable Long id) {
        return Result.success(studentService.findById(id));
    }

    @PostMapping
    public Result<Student> save(@RequestBody Student student) {
        return Result.success(studentService.save(student));
    }

    @PutMapping("/{id}")
    public Result<Student> update(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return Result.success(studentService.update(student));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    //    test
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

    // 文件
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        System.out.println(file.getName());
        return "上传成功";
    }
}
