package com.example.demo.Services;

import com.example.demo.Entities.StudentGroup;
import com.example.demo.Entities.Student;

import java.util.List;

public interface GroupService {
    void addNewGroup(StudentGroup studentGroup);

    List<StudentGroup> getGroupByName(String name);

    List<Student> findStudentsInGroup(String groupName);

}
