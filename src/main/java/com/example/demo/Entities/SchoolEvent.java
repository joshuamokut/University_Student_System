package com.example.demo.Entities;

import com.example.demo.Utilities.SchoolEventType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class SchoolEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private SchoolEventType schoolEventType;
    private String venue;
    private String eventName;
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalDate endDate;
    private LocalTime endTime;

    protected SchoolEvent() {
    }

    public SchoolEvent(SchoolEventType schoolEventType, String venue, String eventName, LocalDate startDate, LocalTime startTime) {
        this.schoolEventType = schoolEventType;
        this.venue = venue;
        this.eventName = eventName;
        this.startDate = startDate;
        this.startTime = startTime;
    }

}
