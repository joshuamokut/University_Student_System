package com.example.demo.Mappers;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.Entities.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@AllArgsConstructor
@Component
public class StudentArrayMapper {
    private final StudentMapper studentMapper;

    public ArrayList<StudentDTO> MapStudentsToArray(ArrayList<Student>students){
        ArrayList<StudentDTO> studentDTOS =new ArrayList<>();

        for(Student student: students){

            studentDTOS.add(studentMapper.MapStudent(student));
        }

        return studentDTOS;
    }
}
