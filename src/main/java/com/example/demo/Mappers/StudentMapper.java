package com.example.demo.Mappers;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.Entities.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class StudentMapper {

    StudentDTO mapStudentToDTO(Student student){
        return new StudentDTO(student.getName(), student.getSurname(),
                student.getStudentGroup().getName());
    }

    public List<StudentDTO> mapStudentsToDTOArray(List<Student>students){

        List<StudentDTO> studentDTOS = new ArrayList<>();

        for(Student student: students){

            studentDTOS.add(mapStudentToDTO(student));
        }

        return studentDTOS;
    }
}
