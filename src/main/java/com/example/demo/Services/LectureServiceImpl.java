package com.example.demo.Services;

import com.example.demo.Entities.Lecture;
import com.example.demo.Respositories.LectureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@Service
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;

    @Override
    public List<Lecture> showEventsToday() {
        return lectureRepository.findAllByStartDateEquals(LocalDate.now());
    }

    @Override
    public void addEvent(List<Lecture> event) {
        for(Lecture lecture: event) {
            lectureRepository.save(lecture);
        }
    }

    @Override
    public List<Lecture> showEventsOn(LocalDate date) {
        return lectureRepository.findAllByStartDateEquals(date);
    }

    @Override
    public List<Lecture> showEventsOn(LocalDate date, LocalTime time) {
        return lectureRepository.findAllByStartDateAndStartTime(date, time);
    }

    @Override
    public List<Lecture> showAll() {
        return lectureRepository.findAllBy();
    }

    @Override
    public List<Lecture> showEvent(String eventName) {
        return lectureRepository.findAllByEventName(eventName);
    }

    @Override
    public List<Lecture> showEventsAt(String venue) {
        return lectureRepository.findAllByVenue(venue);
    }

    @Override
    public List<Lecture> showEventsAt(String venue, LocalDate date) {
        return lectureRepository.findAllByVenueAndStartDate(venue, date);
    }

    @Override
    public List<Lecture> showEventsAt(String venue, LocalDate date, LocalTime time) {
        return lectureRepository.findAllByVenueAndStartDateAndStartTime(venue, date, time);
    }
}
