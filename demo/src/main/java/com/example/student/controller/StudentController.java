package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import com.example.student.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 查询学生列表信息
     * @return Result
     */
    @GetMapping("/list")
    public Result<List<Student>> list() {
        return Result.success(studentService.list());
    }
}
