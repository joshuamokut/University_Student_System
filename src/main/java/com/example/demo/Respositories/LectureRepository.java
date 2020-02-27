package com.example.demo.Respositories;

import com.example.demo.Entities.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

    ArrayList<Lecture> findall();

    ArrayList<Lecture> findAllByStartDateEquals(LocalDate date);

    ArrayList<Lecture> findAllByStartDateAndStartTime(LocalDate date, LocalTime time);

    ArrayList<Lecture> findAllByEventName(String eventName);

    ArrayList<Lecture> findAllByVenue(String venue);

    ArrayList<Lecture> findAllByVenueAndStartDate(String venue, LocalDate date);

    ArrayList<Lecture> findAllByVenueAndStartDateAndStartTime(String venue, LocalDate date, LocalTime time);


}
