package com.example.demo.Mappers;

import com.example.demo.DTO.LectureDTO;
import com.example.demo.DTO.StudentDTO;
import com.example.demo.Entities.Lecture;
import com.example.demo.Entities.Student;
import com.example.demo.Entities.StudentGroup;
import com.example.demo.Utilities.CustomDuration;
import com.example.demo.Utilities.CustomTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Component
public class LectureMapper {

    private final StudentMapper studentMapper;
    private List<StudentDTO> studentDTOList;

    protected LectureDTO mapLecture(Lecture lecture){
        studentDTOList.clear();

        for(StudentGroup group: lecture.getStudentGroups()){
            for(Student student: group.getStudents()){
                studentDTOList.add(studentMapper.mapStudentToDTO(student));
            }
        }

        return new LectureDTO(new CustomDuration(lecture.getStartDate().atTime(lecture.getStartTime()),
                lecture.getEndDate().atTime(lecture.getEndTime())),
                lecture.getVenue(),
                new CustomTime(lecture.getStartDate().atTime(lecture.getStartTime())),
                new CustomTime(lecture.getEndDate().atTime(lecture.getEndTime())),
                studentDTOList
                );
    }

    public List<LectureDTO> mapLecturesToArrayDTO(List<Lecture> lectures){

        List<LectureDTO> lectureDTOS= new ArrayList<>();

        for(Lecture lecture: lectures){
            lectureDTOS.add(mapLecture(lecture));
        }

        return lectureDTOS;
    }
}
