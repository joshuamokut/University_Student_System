package com.example.demo.Services;

import com.example.demo.Entities.Student;

import java.util.ArrayList;


public interface StudentService {
    void addNewStudent(Student student);

    ArrayList<Student> findStudentsByName(String name);

    ArrayList<Student> findStudentsAboveAge(int age);

    ArrayList<Student> showAllStudents();
}
