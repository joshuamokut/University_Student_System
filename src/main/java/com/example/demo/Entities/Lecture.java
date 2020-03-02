package com.example.demo.Entities;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

    @NonNull
    @ElementCollection
    private List<String> studentGroupNames;

    @ManyToMany
    private List<StudentGroup> studentGroups = new ArrayList<>();

    protected Lecture() {
    }

}
