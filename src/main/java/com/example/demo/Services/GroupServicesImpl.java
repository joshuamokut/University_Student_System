package com.example.demo.Services;

import com.example.demo.Entities.Group;
import com.example.demo.Entities.Student;
import com.example.demo.Respositories.GroupRepository;
import com.example.demo.Respositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServicesImpl implements GroupServices {

    GroupRepository groupRepository;
    StudentRepository studentRepository;

    public GroupServicesImpl(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void addNewGroup(Group group) {
        groupRepository.save(group);
    }

    @Override
    public List<Group> getGroupByName(String name) {
        return groupRepository.findAllByName(name);
    }


    @Override
    public List<Student> findStudentsInGroup(String groupName) {
        return studentRepository.findAllByGroupIdEquals(groupRepository.findFirstByName(groupName).getId());
    }
}
