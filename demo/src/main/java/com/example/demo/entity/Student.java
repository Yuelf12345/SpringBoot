package com.example.demo.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
@TableName("student")
public class Student {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    private String email;
}
