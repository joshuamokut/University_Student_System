package com.example.demo.Services;

import com.example.demo.Entities.SchoolEvent;
import com.example.demo.Respositories.SchoolEventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class SchoolEventServiceImpl implements SchoolEventService {

    private SchoolEventRepository schoolEventRepository;

    public SchoolEventServiceImpl(SchoolEventRepository schoolEventRepository) {
        this.schoolEventRepository = schoolEventRepository;
    }

    @Override
    public List<SchoolEvent> showEventsToday() {
        return schoolEventRepository.findAllByStartDateEquals(LocalDate.now());
    }

    @Override
    public void addEvent(SchoolEvent event) {
        schoolEventRepository.save(event);
    }

    @Override
    public List<SchoolEvent> showEventsOn(LocalDate date) {
        return schoolEventRepository.findAllByStartDateEquals(date);
    }

    @Override
    public List<SchoolEvent> showEventsOn(LocalDate date, LocalTime time) {
        return schoolEventRepository.findAllByStartDateAndStartTime(date, time);
    }

    @Override
    public List<SchoolEvent> showAll() {
        return schoolEventRepository.findAll();
    }

    @Override
    public List<SchoolEvent> showEvent(String eventName) {
        return schoolEventRepository.findAllByEventName(eventName);
    }

    @Override
    public List<SchoolEvent> showEventsAt(String venue) {
        return schoolEventRepository.findAllByVenue(venue);
    }

    @Override
    public List<SchoolEvent> showEventsAt(String venue, LocalDate date) {
        return schoolEventRepository.findAllByVenueAndStartDate(venue, date);
    }

    @Override
    public List<SchoolEvent> showEventsAt(String venue, LocalDate date, LocalTime time) {
        return schoolEventRepository.findAllByVenueAndStartDateAndStartTime(venue, date, time);
    }
}
