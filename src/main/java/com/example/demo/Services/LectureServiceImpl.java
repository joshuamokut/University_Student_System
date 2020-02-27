package com.example.demo.Services;

import com.example.demo.Entities.Lecture;
import com.example.demo.Respositories.LectureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@AllArgsConstructor
@Service
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;

    @Override
    public ArrayList<Lecture> showEventsToday() {
        return lectureRepository.findAllByStartDateEquals(LocalDate.now());
    }

    @Override
    public void addEvent(ArrayList<Lecture> event) {
        for(Lecture lecture: event) {
            lectureRepository.save(lecture);
        }
    }

    @Override
    public ArrayList<Lecture> showEventsOn(LocalDate date) {
        return lectureRepository.findAllByStartDateEquals(date);
    }

    @Override
    public ArrayList<Lecture> showEventsOn(LocalDate date, LocalTime time) {
        return lectureRepository.findAllByStartDateAndStartTime(date, time);
    }

    @Override
    public ArrayList<Lecture> showAll() {
        return lectureRepository.findAllBy();
    }

    @Override
    public ArrayList<Lecture> showEvent(String eventName) {
        return lectureRepository.findAllByEventName(eventName);
    }

    @Override
    public ArrayList<Lecture> showEventsAt(String venue) {
        return lectureRepository.findAllByVenue(venue);
    }

    @Override
    public ArrayList<Lecture> showEventsAt(String venue, LocalDate date) {
        return lectureRepository.findAllByVenueAndStartDate(venue, date);
    }

    @Override
    public ArrayList<Lecture> showEventsAt(String venue, LocalDate date, LocalTime time) {
        return lectureRepository.findAllByVenueAndStartDateAndStartTime(venue, date, time);
    }
}
