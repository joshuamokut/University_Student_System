package com.example.demo.Entities;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@RequiredArgsConstructor
@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull private String venue;
    @NonNull private String eventName;
    @NonNull private LocalDate startDate;
    @NonNull private LocalTime startTime;
    @NonNull private LocalDate endDate;
    @NonNull private LocalTime endTime;
    @NonNull private String groupName;

    protected Lecture() {
    }

}
