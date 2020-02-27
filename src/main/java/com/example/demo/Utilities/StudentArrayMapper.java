package com.example.demo.Utilities;

import com.example.demo.Entities.Student;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
public class StudentArrayMapper {
    private final StudentMapper studentMapper;

    ArrayList<StudentDTO> MapStudentDtoArray(ArrayList<Student>students){
        ArrayList<StudentDTO> studentDTOS =new ArrayList<>();

        for(Student student: students){

            studentDTOS.add(studentMapper.MapStudent(student));
        }

        return studentDTOS;
    }
}