package com.example.demo.Services;

import com.example.demo.Entities.Student;
import com.example.demo.Respositories.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService{


    private StudentRepository studentRepository;

    @Override
    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findStudentsByName(String name) {
        return studentRepository.findAllByName(name);
    }

    @Override
    public List<Student> findStudentsAboveAge(int age) {
        567,648,000,000
    }

    @Override
    public List<Student> findStudentsInGroup(String groupName) {
        return null;
    }
}
