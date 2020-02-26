package com.example.demo.Controllers;

import com.example.demo.Entities.SchoolEvent;
import com.example.demo.Services.SchoolEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("event")
public class SchoolEventController {

    private final SchoolEventService schoolEventService;

    @Autowired
    public SchoolEventController(SchoolEventService schoolEventService) {
        this.schoolEventService = schoolEventService;
    }


    @PostMapping("add")
    String AddEvent(@RequestBody SchoolEvent schoolEvent){
        schoolEventService.addEvent(schoolEvent);

        return "Event Added\n";
    }

    @GetMapping("all")
    List<SchoolEvent> ShowAll(){
        return schoolEventService.showAll();
    }

    @GetMapping("today")
    List<SchoolEvent> ShowToday(){
        return schoolEventService.showEventsToday();
    }

    @GetMapping("date")
    List<SchoolEvent> ShowEventsOn(@RequestParam String date){
        try {
            return schoolEventService.showEventsOn(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }catch (DateTimeParseException e) {
            return null;
        }
    }

    @GetMapping("date/time")
    List<SchoolEvent> ShowEventsOn(@RequestParam String date, @RequestParam String time){
        try {
            return schoolEventService.showEventsOn(
                    LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"))
            );
        }
        catch(DateTimeParseException e){
            return null;
        }
    }

    List<SchoolEvent> ShowEvent(@RequestParam String eventName){
        return schoolEventService.showEvent(eventName);
    }

    @GetMapping("venue")
    List<SchoolEvent> ShowEventsAt(@RequestParam String venue){
        return schoolEventService.showEventsAt(venue);
    }

    @GetMapping("venue/date")
    List<SchoolEvent> ShowEventsAt(@RequestParam String venue, @RequestParam String date){
        try{
            return schoolEventService.showEventsAt(
                    venue, LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            );

        }catch (DateTimeParseException e){
            return null;
        }
    }

    @GetMapping("venue/date/time")
    List<SchoolEvent> ShowEventsAt(@RequestParam String venue, @RequestParam String date, @RequestParam String time){
        try{
            return schoolEventService.showEventsAt(
                    venue, LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"))
            );

        }catch (DateTimeParseException e){
            return null;
        }
    }



}