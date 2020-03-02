package com.example.demo.Services;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.Entities.Student;

import java.util.List;


public interface StudentService {
    void addNewStudent(List<Student> students);

    List<StudentDTO> findStudentsByName(String name);

    List<StudentDTO> findStudentsAboveAge(int age);

    List<StudentDTO> showAllStudents();
}
