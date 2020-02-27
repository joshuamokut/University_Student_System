package com.example.demo.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String venue;
    private String eventName;
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalDate endDate;
    private LocalTime endTime;
    private String groupName;

    protected Lecture() {
    }

    public Lecture(String venue, String eventName, LocalDate startDate, LocalTime startTime, String groupName) {
        this.venue = venue;
        this.groupName=groupName;
        this.eventName = eventName;
        this.startDate = startDate;
        this.startTime = startTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
