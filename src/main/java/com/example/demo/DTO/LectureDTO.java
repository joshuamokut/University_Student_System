package com.example.demo.DTO;

import com.example.demo.Utilities.CustomDuration;
import com.example.demo.Utilities.CustomTime;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LectureDTO {

    private CustomDuration duration;

    private String venue;

    private CustomTime startTime;

    private CustomTime endTime;

    private List<StudentDTO> students;


}
