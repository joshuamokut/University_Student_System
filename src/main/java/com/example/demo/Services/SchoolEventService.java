package com.example.demo.Services;

import com.example.demo.Entities.SchoolEvent;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface SchoolEventService {
    List<SchoolEvent> showEventsToday();

    void addEvent(SchoolEvent event);

    List<SchoolEvent> showEventsOn(LocalDate date);

    List<SchoolEvent> showEventsOn(LocalDate date, LocalTime time);

    List<SchoolEvent> showEventsAt(String venue);

    List<SchoolEvent> showEventsAt(String venue, LocalDate date);

    List<SchoolEvent> showEventsAt(String Venue, LocalDate date, LocalTime time);

    List<SchoolEvent> showAll();

    List<SchoolEvent> showEvent(String eventName);
}
