package com.example.demo.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Entity
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull private String name;
    @NonNull private String description;
    @NonNull
    @OneToMany
    private Set<Student> students;

    protected StudentGroup(){}

}
