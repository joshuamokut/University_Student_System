package com.example.demo.Utilities;

import com.example.demo.Entities.Student;
import com.example.demo.Respositories.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class StudentMapper {
    private final GroupRepository groupRepository;

    public StudentDTO MapStudent(Student student){
        return new StudentDTO(student.getName(), student.getSurname(),
                groupRepository.findFirstById(student.getId()).getName());
    }
}
