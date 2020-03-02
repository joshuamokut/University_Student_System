package com.example.demo.Mappers;

import com.example.demo.DTO.StudentGroupDTO;
import com.example.demo.Entities.StudentGroup;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class StudentGroupMapper {
    private final StudentMapper studentMapper;

    protected StudentGroupDTO mapStudentGroup(StudentGroup studentGroup){
        return new StudentGroupDTO(studentGroup.getName(), studentGroup.getDescription(), studentMapper.mapStudentsToDTOArray(studentGroup.getStudents()));
    }

    public List<StudentGroupDTO> mapStudentGroupsToDTOArray(List<StudentGroup> studentGroups){
        List<StudentGroupDTO> groupList = new ArrayList<>();
        for(StudentGroup studentGroup: studentGroups){
            groupList.add(mapStudentGroup(studentGroup));
        }
        return groupList;
    }
}
