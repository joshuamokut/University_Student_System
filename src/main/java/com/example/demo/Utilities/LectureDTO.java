package com.example.demo.Utilities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class LectureDTO {

    private CustomDuration duration;

    private String venue;

    private CustomTime startTime;

    private CustomTime endTime;

    private ArrayList<StudentDTO> students;


}
