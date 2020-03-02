package com.example.demo.Entities;

import com.example.demo.Utilities.Gender;
import lombok.Data;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


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

    public Student(String name, String surname, String dateOfBirth, Gender gender, String studentGroupName) {
        this.name=name;
        this.surname=surname;
        this.dateOfBirth=LocalDate.parse(dateOfBirth,  DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.gender=gender;
        this.studentGroupName=studentGroupName;
    }


}
