package com.example.demo.Controllers;

import com.example.demo.DTO.LectureDTO;
import com.example.demo.Entities.Lecture;
import com.example.demo.Mappers.LectureArrayMapper;
import com.example.demo.Services.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

@RestController
@RequestMapping("lectures")
public class LectureController {

    private final LectureService lectureService;
    private final LectureArrayMapper lectureArrayMapper;
    @Autowired
    public LectureController(LectureService lectureService, LectureArrayMapper lectureArrayMapper) {
        this.lectureService = lectureService;
        this.lectureArrayMapper = lectureArrayMapper;
    }


    @PostMapping("add")
    String AddEvent(@RequestBody ArrayList<Lecture> lecture){
        lectureService.addEvent(lecture);

        return "Event Added\n";
    }

    @GetMapping("all")
    ArrayList<LectureDTO> ShowAll(){
        return lectureArrayMapper.MapLecturesToArray(lectureService.showAll());
    }

    @GetMapping("today")
    ArrayList<LectureDTO> ShowToday(){
        return lectureArrayMapper.MapLecturesToArray(lectureService.showEventsToday());
    }

    @GetMapping("date")
    ArrayList<LectureDTO> ShowEventsOn(@RequestParam String date){
        try {
            return lectureArrayMapper.MapLecturesToArray(lectureService.showEventsOn(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
        }catch (DateTimeParseException e) {
            return null;
        }
    }

    @GetMapping("date/time")
    ArrayList<LectureDTO> ShowEventsOn(@RequestParam String date, @RequestParam String time){
        try {
            return lectureArrayMapper.MapLecturesToArray(lectureService.showEventsOn(
                    LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"))
            ));
        }
        catch(DateTimeParseException e){
            return null;
        }
    }

    @GetMapping("/title")
    ArrayList<LectureDTO> ShowEvent(@RequestParam String eventName){
        return lectureArrayMapper.MapLecturesToArray(lectureService.showEvent(eventName));
    }

    @GetMapping("venue")
    ArrayList<LectureDTO> ShowEventsAt(@RequestParam String venue)
    {
        return lectureArrayMapper.MapLecturesToArray(lectureService.showEventsAt(venue));
    }

    @GetMapping("venue/date")
    ArrayList<LectureDTO> ShowEventsAt(@RequestParam String venue, @RequestParam String date){
        try{
            return lectureArrayMapper.MapLecturesToArray(lectureService.showEventsAt(
                    venue, LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            ));

        }catch (DateTimeParseException e){
            return null;
        }
    }

    @GetMapping("venue/date/time")
    ArrayList<LectureDTO> ShowEventsAt(@RequestParam String venue, @RequestParam String date, @RequestParam String time){
        try{
            return lectureArrayMapper.MapLecturesToArray(lectureService.showEventsAt(
                    venue, LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"))
            ));

        }catch (DateTimeParseException e){
            return null;
        }
    }



}
