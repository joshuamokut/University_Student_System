package com.example.demo.Utilities;

import com.example.demo.Entities.Lecture;
import com.example.demo.Respositories.GroupRepository;
import com.example.demo.Respositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class LectureMapper {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final StudentArrayMapper studentArrayMapper;


    public LectureDto MapLecture(Lecture lecture){
        return new LectureDto(new CustomDuration(lecture.getStartDate().atTime(lecture.getStartTime()),
                lecture.getEndDate().atTime(lecture.getEndTime())),
                lecture.getVenue(),
                new CustomTime(lecture.getStartDate().atTime(lecture.getStartTime())),
                new CustomTime(lecture.getEndDate().atTime(lecture.getEndTime())),
                studentArrayMapper.MapStudentDtoArray(studentRepository.findAllByGroupIdEquals(groupRepository.findFirstByName(lecture.getGroupName()).getId()))
                );
    }
}
