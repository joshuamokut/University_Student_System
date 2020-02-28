package com.example.demo.Services;

import com.example.demo.Entities.StudentGroup;
import com.example.demo.Entities.Student;

import java.util.List;

public interface GroupService {
    void addNewGroup(List<StudentGroup> studentGroups);

    List<StudentGroup> getGroupByName(String name);

    List<Student> findStudentsInGroup(String groupName);

}
