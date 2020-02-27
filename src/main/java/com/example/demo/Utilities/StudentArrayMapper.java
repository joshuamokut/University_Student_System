package com.example.demo.Utilities;

import com.example.demo.Entities.Student;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
public class StudentArrayMapper {
    private final StudentMapper studentMapper;

    ArrayList<StudentDto> MapStudentDtoArray(ArrayList<Student>students){
        ArrayList<StudentDto> studentDtos=new ArrayList<>();

        for(Student student: students){

            studentDtos.add(studentMapper.MapStudent(student));
        }

        return studentDtos;
    }
}
