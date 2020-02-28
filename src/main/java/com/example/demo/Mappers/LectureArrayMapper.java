package com.example.demo.Mappers;

import com.example.demo.DTO.LectureDTO;
import com.example.demo.Entities.Lecture;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class LectureArrayMapper {
    private final LectureMapper lectureMapper;
    private List<LectureDTO> lectureDTOS;

    public List<LectureDTO>MapLecturesToArray(List<Lecture> lectures){

        lectureDTOS.clear();
        for(Lecture lecture: lectures){
            lectureDTOS.add(lectureMapper.mapLecture(lecture));
        }

        return lectureDTOS;
    }
}
