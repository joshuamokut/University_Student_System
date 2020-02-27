package com.example.demo.Utilities;

import com.example.demo.Entities.Student;
import com.example.demo.Respositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class StudentMapper {
    private final GroupRepository groupRepository;

    @Autowired
    public StudentMapper(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

    public StudentDto MapStudent(Student student){
        return new StudentDto(student.getName(), student.getSurname(),
                groupRepository.findFirstById(student.getId()).getName());
    }
}
