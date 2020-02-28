package com.example.demo.Services;

import com.example.demo.Entities.Lecture;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface LectureService {
    List<Lecture> showEventsToday();

    void addEvent(List<Lecture> event);

    List<Lecture> showEventsOn(LocalDate date);

    List<Lecture> showEventsOn(LocalDate date, LocalTime time);

    List<Lecture> showEventsAt(String venue);

    List<Lecture> showEventsAt(String venue, LocalDate date);

    List<Lecture> showEventsAt(String Venue, LocalDate date, LocalTime time);

    List<Lecture> showAll();

    List<Lecture> showEvent(String eventName);
}
