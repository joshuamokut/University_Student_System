package com.example.demo.Mappers;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.Entities.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class StudentMapper {
    private List<StudentDTO> studentDTOS;

    public StudentDTO MapStudent(Student student){
        return new StudentDTO(student.getName(), student.getSurname(),
                student.getGroup().getName());
    }

    public List<StudentDTO> MapStudentsToArray(List<Student>students){

        studentDTOS.clear();

        for(Student student: students){

            studentDTOS.add(MapStudent(student));
        }

        return studentDTOS;
    }
}
