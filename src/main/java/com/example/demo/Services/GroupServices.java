package com.example.demo.Services;

import com.example.demo.Entities.Group;
import com.example.demo.Entities.Student;

import java.util.List;

public interface GroupServices {
    void addNewGroup(Group group);
    List<Group> getGroupByName(String name);
    List<Student> findStudentsInGroup(String groupName);

}
