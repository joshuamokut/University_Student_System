package com.example.demo.Mappers;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.Entities.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class StudentArrayMapper {
    private final StudentMapper studentMapper;
    private List<StudentDTO> studentDTOS;

    public List<StudentDTO> MapStudentsToArray(List<Student>students){

        studentDTOS.clear();

        for(Student student: students){

            studentDTOS.add(studentMapper.MapStudent(student));
        }

        return studentDTOS;
    }
}
