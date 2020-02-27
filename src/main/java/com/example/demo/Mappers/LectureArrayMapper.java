package com.example.demo.Mappers;

import com.example.demo.DTO.LectureDTO;
import com.example.demo.Entities.Lecture;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@AllArgsConstructor
@Component
public class LectureArrayMapper {
    private final LectureMapper lectureMapper;

    public ArrayList<LectureDTO>MapLecturesToArray(ArrayList<Lecture> lectures){
        ArrayList<LectureDTO> lectureDTOS=new ArrayList<>();

        for(Lecture lecture: lectures){
            lectureDTOS.add(lectureMapper.MapLecture(lecture));
        }

        return lectureDTOS;
    }
}
