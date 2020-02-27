package com.example.demo.Respositories;

import com.example.demo.Entities.SchoolEvent;
import com.example.demo.Utilities.SchoolEventType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public interface SchoolEventRepository extends JpaRepository<SchoolEvent, Long> {
    ArrayList<SchoolEvent> findAll();

    ArrayList<SchoolEvent> findAllByStartDateEquals(LocalDate date);

    ArrayList<SchoolEvent> findAllByStartDateAndStartTime(LocalDate date, LocalTime time);

    ArrayList<SchoolEvent> findAllByEventName(String eventName);

    ArrayList<SchoolEvent> findAllByVenue(String venue);

    ArrayList<SchoolEvent> findAllByVenueAndStartDate(String venue, LocalDate date);

    ArrayList<SchoolEvent> findAllByVenueAndStartDateAndStartTime(String venue, LocalDate date, LocalTime time);
}
