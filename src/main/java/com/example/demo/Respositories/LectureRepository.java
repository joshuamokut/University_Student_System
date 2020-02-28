package com.example.demo.Respositories;

import com.example.demo.Entities.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

    List<Lecture> findAllBy();

    List<Lecture> findAllByStartDateEquals(LocalDate date);

    List<Lecture> findAllByStartDateAndStartTime(LocalDate date, LocalTime time);

    List<Lecture> findAllByEventName(String eventName);

    List<Lecture> findAllByVenue(String venue);

    List<Lecture> findAllByVenueAndStartDate(String venue, LocalDate date);

    List<Lecture> findAllByVenueAndStartDateAndStartTime(String venue, LocalDate date, LocalTime time);


}
