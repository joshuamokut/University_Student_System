package com.example.demo.Controllers;

import com.example.demo.Entities.Lecture;
import com.example.demo.Services.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

@RestController
@RequestMapping("event")
public class LectureController {

    private final LectureService lectureService;

    @Autowired
    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }


    @PostMapping("add")
    String AddEvent(@RequestBody Lecture lecture){
        lectureService.addEvent(lecture);

        return "Event Added\n";
    }

    @GetMapping("all")
    ArrayList<Lecture> ShowAll(){
        return lectureService.showAll();
    }

    @GetMapping("today")
    ArrayList<Lecture> ShowToday(){
        return lectureService.showEventsToday();
    }

    @GetMapping("date")
    ArrayList<Lecture> ShowEventsOn(@RequestParam String date){
        try {
            return lectureService.showEventsOn(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }catch (DateTimeParseException e) {
            return null;
        }
    }

    @GetMapping("date/time")
    ArrayList<Lecture> ShowEventsOn(@RequestParam String date, @RequestParam String time){
        try {
            return lectureService.showEventsOn(
                    LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"))
            );
        }
        catch(DateTimeParseException e){
            return null;
        }
    }

    @GetMapping("/title")
    ArrayList<Lecture> ShowEvent(@RequestParam String eventName){
        return lectureService.showEvent(eventName);
    }

    @GetMapping("venue")
    ArrayList<Lecture> ShowEventsAt(@RequestParam String venue){
        return lectureService.showEventsAt(venue);
    }

    @GetMapping("venue/date")
    ArrayList<Lecture> ShowEventsAt(@RequestParam String venue, @RequestParam String date){
        try{
            return lectureService.showEventsAt(
                    venue, LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            );

        }catch (DateTimeParseException e){
            return null;
        }
    }

    @GetMapping("venue/date/time")
    ArrayList<Lecture> ShowEventsAt(@RequestParam String venue, @RequestParam String date, @RequestParam String time){
        try{
            return lectureService.showEventsAt(
                    venue, LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"))
            );

        }catch (DateTimeParseException e){
            return null;
        }
    }



}
