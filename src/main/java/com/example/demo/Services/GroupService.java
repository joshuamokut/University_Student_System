package com.example.demo.Services;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.DTO.StudentGroupDTO;
import com.example.demo.Entities.StudentGroup;
import com.example.demo.Entities.Student;

import java.util.List;

public interface GroupService {
    void addNewGroup(List<StudentGroup> studentGroups);

    List<StudentGroupDTO> getGroupByName(String name);

    List<StudentDTO> findStudentsInGroup(String groupName);

}
