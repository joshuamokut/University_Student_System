package com.example.demo.Services;

import com.example.demo.Entities.StudentGroup;
import com.example.demo.Entities.Student;

import java.util.ArrayList;

public interface GroupService {
    void addNewGroup(ArrayList<StudentGroup> studentGroups);

    ArrayList<StudentGroup> getGroupByName(String name);

    ArrayList<Student> findStudentsInGroup(String groupName);

}
