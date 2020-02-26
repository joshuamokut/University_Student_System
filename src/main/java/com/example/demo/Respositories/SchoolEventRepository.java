package com.example.demo.Respositories;

import com.example.demo.Entities.SchoolEvent;
import com.example.demo.Utilities.SchoolEventType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface SchoolEventRepository extends JpaRepository<SchoolEvent, Long> {
    List<SchoolEvent> findAllByStartDateEquals(LocalDate date);

    List<SchoolEvent> findAllByStartDateAndStartTime(LocalDate date, LocalTime time);

    List<SchoolEvent> findAllByEventName(String eventName);

    List<SchoolEvent> findAllByStartDateEqualsAndSchoolEventType(LocalDate date, SchoolEventType schoolEventType);

    List<SchoolEvent> findAllByEventNameAndStartDate(String eventName, LocalDate date);

    List<SchoolEvent> findAllByVenue(String venue);

    List<SchoolEvent> findAllByVenueAndStartDate(String venue, LocalDate date);

    List<SchoolEvent> findAllByVenueAndStartDateAndStartTime(String venue, LocalDate date, LocalTime time);
}
