package com.example.demo.Services;

import com.example.demo.Entities.SchoolEvent;
import com.example.demo.Respositories.SchoolEventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Service
public class SchoolEventServiceImpl implements SchoolEventService {

    private SchoolEventRepository schoolEventRepository;

    public SchoolEventServiceImpl(SchoolEventRepository schoolEventRepository) {
        this.schoolEventRepository = schoolEventRepository;
    }

    @Override
    public ArrayList<SchoolEvent> showEventsToday() {
        return schoolEventRepository.findAllByStartDateEquals(LocalDate.now());
    }

    @Override
    public void addEvent(SchoolEvent event) {
        schoolEventRepository.save(event);
    }

    @Override
    public ArrayList<SchoolEvent> showEventsOn(LocalDate date) {
        return schoolEventRepository.findAllByStartDateEquals(date);
    }

    @Override
    public ArrayList<SchoolEvent> showEventsOn(LocalDate date, LocalTime time) {
        return schoolEventRepository.findAllByStartDateAndStartTime(date, time);
    }

    @Override
    public ArrayList<SchoolEvent> showAll() {
        return schoolEventRepository.findAll();
    }

    @Override
    public ArrayList<SchoolEvent> showEvent(String eventName) {
        return schoolEventRepository.findAllByEventName(eventName);
    }

    @Override
    public ArrayList<SchoolEvent> showEventsAt(String venue) {
        return schoolEventRepository.findAllByVenue(venue);
    }

    @Override
    public ArrayList<SchoolEvent> showEventsAt(String venue, LocalDate date) {
        return schoolEventRepository.findAllByVenueAndStartDate(venue, date);
    }

    @Override
    public ArrayList<SchoolEvent> showEventsAt(String venue, LocalDate date, LocalTime time) {
        return schoolEventRepository.findAllByVenueAndStartDateAndStartTime(venue, date, time);
    }
}
