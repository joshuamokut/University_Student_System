package com.example.demo.Services;

import com.example.demo.DTO.LectureDTO;
import com.example.demo.Entities.Lecture;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface LectureService {
    List<LectureDTO> showEventsToday();

    void addEvent(List<Lecture> event);

    List<LectureDTO> showEventsOn(LocalDate date);

    List<LectureDTO> showEventsOn(LocalDate date, LocalTime time);

    List<LectureDTO> showEventsAt(String venue);

    List<LectureDTO> showEventsAt(String venue, LocalDate date);

    List<LectureDTO> showEventsAt(String Venue, LocalDate date, LocalTime time);

    List<LectureDTO> showAll();

    List<LectureDTO> showEvent(String eventName);
}
