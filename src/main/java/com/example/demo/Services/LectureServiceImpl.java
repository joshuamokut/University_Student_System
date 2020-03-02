package com.example.demo.Services;

import com.example.demo.DTO.LectureDTO;
import com.example.demo.Entities.Lecture;
import com.example.demo.Mappers.LectureMapper;
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
    private final LectureMapper lectureMapper;

    @Override
    public List<LectureDTO> showEventsToday() {
        return lectureMapper.mapLecturesToArrayDTO(lectureRepository.findAllByStartDateEquals(LocalDate.now()));
    }

    @Override
    public void addEvent(List<Lecture> event) {
        for(Lecture lecture: event) {
            lectureRepository.save(lecture);
        }
    }

    @Override
    public List<LectureDTO> showEventsOn(LocalDate date) {
        return lectureMapper.mapLecturesToArrayDTO(lectureRepository.findAllByStartDateEquals(date));
    }

    @Override
    public List<LectureDTO> showEventsOn(LocalDate date, LocalTime time) {
        return lectureMapper.mapLecturesToArrayDTO(lectureRepository.findAllByStartDateAndStartTime(date, time));
    }

    @Override
    public List<LectureDTO> showAll() {
        return lectureMapper.mapLecturesToArrayDTO(lectureRepository.findAllBy());
    }

    @Override
    public List<LectureDTO> showEvent(String eventName) {
        return lectureMapper.mapLecturesToArrayDTO(lectureRepository.findAllByEventName(eventName));
    }

    @Override
    public List<LectureDTO> showEventsAt(String venue) {
        return lectureMapper.mapLecturesToArrayDTO(lectureRepository.findAllByVenue(venue));
    }

    @Override
    public List<LectureDTO> showEventsAt(String venue, LocalDate date) {
        return lectureMapper.mapLecturesToArrayDTO(lectureRepository.findAllByVenueAndStartDate(venue, date));
    }

    @Override
    public List<LectureDTO> showEventsAt(String venue, LocalDate date, LocalTime time) {
        return lectureMapper.mapLecturesToArrayDTO(lectureRepository.findAllByVenueAndStartDateAndStartTime(venue, date, time));
    }
}
