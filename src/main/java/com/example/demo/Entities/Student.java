package com.example.demo.Entities;

import com.example.demo.Utilities.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

@AllArgsConstructor
@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String studentGroupName;


    @ManyToOne
    private StudentGroup studentGroup;

    protected Student(){}




}
