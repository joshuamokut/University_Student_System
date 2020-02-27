package com.example.demo.Services;

import com.example.demo.Entities.Lecture;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public interface LectureService {
    ArrayList<Lecture> showEventsToday();

    void addEvent(Lecture event);

    ArrayList<Lecture> showEventsOn(LocalDate date);

    ArrayList<Lecture> showEventsOn(LocalDate date, LocalTime time);

    ArrayList<Lecture> showEventsAt(String venue);

    ArrayList<Lecture> showEventsAt(String venue, LocalDate date);

    ArrayList<Lecture> showEventsAt(String Venue, LocalDate date, LocalTime time);

    ArrayList<Lecture> showAll();

    ArrayList<Lecture> showEvent(String eventName);
}
