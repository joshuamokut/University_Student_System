package com.example.demo.Services;

import com.example.demo.Entities.SchoolEvent;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public interface SchoolEventService {
    ArrayList<SchoolEvent> showEventsToday();

    void addEvent(SchoolEvent event);

    ArrayList<SchoolEvent> showEventsOn(LocalDate date);

    ArrayList<SchoolEvent> showEventsOn(LocalDate date, LocalTime time);

    ArrayList<SchoolEvent> showEventsAt(String venue);

    ArrayList<SchoolEvent> showEventsAt(String venue, LocalDate date);

    ArrayList<SchoolEvent> showEventsAt(String Venue, LocalDate date, LocalTime time);

    ArrayList<SchoolEvent> showAll();

    ArrayList<SchoolEvent> showEvent(String eventName);
}
