package com.example.demo.Services;

import com.example.demo.Entities.StudentGroup;
import com.example.demo.Entities.Student;
import com.example.demo.Respositories.GroupRepository;
import com.example.demo.Respositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    GroupRepository groupRepository;
    StudentRepository studentRepository;

    public GroupServiceImpl(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void addNewGroup(StudentGroup studentGroup) {
        groupRepository.save(studentGroup);
    }

    @Override
    public List<StudentGroup> getGroupByName(String name) {
        return groupRepository.findAllByName(name);
    }


    @Override
    public List<Student> findStudentsInGroup(String groupName) {
        return studentRepository.findAllByGroupIdEquals(groupRepository.findFirstByName(groupName).getId());
    }
}
