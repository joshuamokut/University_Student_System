package com.example.demo.Entities;

import javafx.scene.Group;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
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
    @OneToMany
    @NonNull
    private List<StudentGroup> studentGroups;

    protected Lecture() {
    }

}
