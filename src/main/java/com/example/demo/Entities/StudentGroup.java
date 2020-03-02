package com.example.demo.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@RequiredArgsConstructor
@Entity
public class  StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull private String name;
    @NonNull private String description;


    @OneToMany(mappedBy = "studentGroup")
    private List<Student> students;

    @ManyToMany
    private List<Lecture> lectures;

    protected StudentGroup(){}

}
