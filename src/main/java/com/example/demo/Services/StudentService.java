package com.example.demo.Services;

import com.example.demo.Entities.Student;

import java.util.List;


public interface StudentService {
    void addNewStudent(Student student);

    List<Student> findStudentsByName(String name);

    List<Student> findStudentsAboveAge(int age);

    List<Student> showAllStudents();
}
