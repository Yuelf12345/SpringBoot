package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentServiceImpl implements StudentService {

    // 使用List模拟数据存储
    private final List<Student> students = new ArrayList<>();
    // 用于生成自增ID
    private final AtomicLong idGenerator = new AtomicLong(1);

    // 初始化一些测试数据
    public StudentServiceImpl() {
        Student student1 = new Student();
        student1.setId(idGenerator.getAndIncrement());
        student1.setName("张三");
        students.add(student1);

        Student student2 = new Student();
        student2.setId(idGenerator.getAndIncrement());
        student2.setName("李四");
        students.add(student2);
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Student findById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Student save(Student student) {
        student.setId(idGenerator.getAndIncrement());
        students.add(student);
        return student;
    }

    @Override
    public Student update(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(student.getId())) {
                students.set(i, student);
                return student;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }
}
