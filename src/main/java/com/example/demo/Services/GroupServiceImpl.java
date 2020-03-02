package com.example.demo.Services;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.DTO.StudentGroupDTO;
import com.example.demo.Entities.StudentGroup;
import com.example.demo.Mappers.StudentGroupMapper;
import com.example.demo.Mappers.StudentMapper;
import com.example.demo.Respositories.GroupRepository;
import com.example.demo.Respositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GroupServiceImpl implements GroupService {

    GroupRepository groupRepository;
    StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final StudentGroupMapper studentGroupMapper;


    @Override
    public void addNewGroup(List<StudentGroup> studentGroups) {
        groupRepository.saveAll(studentGroups);
    }

    @Override
    public List<StudentGroupDTO> getGroupByName(String name) {
        return studentGroupMapper.mapStudentGroupsToDTOArray(groupRepository.findAllByName(name));
    }


    @Override
    public List<StudentDTO> findStudentsInGroup(String groupName) {
        return studentMapper.mapStudentsToDTOArray(studentRepository.findAllByStudentGroupId(
                groupRepository.findFirstByName(groupName).getId()));
    }

    @Override
    public List<StudentGroupDTO> showAllGroups() {
       return studentGroupMapper.mapStudentGroupsToDTOArray((List<StudentGroup>) groupRepository.findAll());
    }
}
