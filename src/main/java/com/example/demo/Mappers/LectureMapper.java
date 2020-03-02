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
import java.util.List;

@AllArgsConstructor
@Component
public class LectureMapper {

    private final StudentMapper studentMapper;


    LectureDTO mapLecture(Lecture lecture){
        List<StudentDTO> studentDTOList = new ArrayList<>();

        for(StudentGroup group: lecture.getStudentGroups()){
            studentDTOList.addAll(studentMapper.mapStudentsToDTOArray(group.getStudents()));
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
