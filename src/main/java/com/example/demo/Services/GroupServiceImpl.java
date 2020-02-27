package com.example.demo.Services;

import com.example.demo.Entities.StudentGroup;
import com.example.demo.Entities.Student;
import com.example.demo.Respositories.GroupRepository;
import com.example.demo.Respositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@AllArgsConstructor
@Service
public class GroupServiceImpl implements GroupService {

    GroupRepository groupRepository;
    StudentRepository studentRepository;

    @Override
    public void addNewGroup(ArrayList<StudentGroup> studentGroups) {
        for(StudentGroup studentGroup: studentGroups){
            groupRepository.save(studentGroup);
        }
    }

    @Override
    public ArrayList<StudentGroup> getGroupByName(String name) {
        return groupRepository.findAllByName(name);
    }


    @Override
    public ArrayList<Student> findStudentsInGroup(String groupName) {
        return studentRepository.findAllByGroupIdEquals(groupRepository.findFirstByName(groupName).getId());
    }
}
