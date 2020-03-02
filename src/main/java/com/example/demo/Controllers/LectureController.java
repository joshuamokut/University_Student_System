package com.example.demo.Controllers;

import com.example.demo.DTO.LectureDTO;
import com.example.demo.Entities.Lecture;
import com.example.demo.Mappers.LectureMapper;
import com.example.demo.Services.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("lectures")
public class LectureController {

    private final LectureService lectureService;
    @Autowired
    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }


    @PostMapping("add")
    String addEvent(@RequestBody List<Lecture> lecture){
        lectureService.addEvent(lecture);

        return "Event Added\n";
    }

    @GetMapping("all")
    List<LectureDTO> showAll(){
        return lectureService.showAll();
    }

    @GetMapping("today")
    List<LectureDTO> showToday(){
        return lectureService.showEventsToday();
    }

    @GetMapping("date")
    List<LectureDTO> showEventsOn(@RequestParam String date){
        try {
            return lectureService.showEventsOn(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        }catch (DateTimeParseException e) {
            return null;
        }
    }

    @GetMapping("date/time")
    List<LectureDTO> showEventsOn(@RequestParam String date, @RequestParam String time){
        try {
            return lectureService.showEventsOn(
                    LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm")
            ));
        }
        catch(DateTimeParseException e){
            return null;
        }
    }

    @GetMapping("/title")
    List<LectureDTO> showEvent(@RequestParam String eventName){
        return lectureService.showEvent(eventName);
    }

    @GetMapping("venue")
    List<LectureDTO> showEventsAt(@RequestParam String venue)
    {
        return lectureService.showEventsAt(venue);
    }

    @GetMapping("venue/date")
    List<LectureDTO> showEventsAt(@RequestParam String venue, @RequestParam String date){
        try{
            return lectureService.showEventsAt(
                    venue, LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            );

        }catch (DateTimeParseException e){
            return null;
        }
    }

    @GetMapping("venue/date/time")
    List<LectureDTO> showEventsAt(@RequestParam String venue, @RequestParam String date, @RequestParam String time){
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
