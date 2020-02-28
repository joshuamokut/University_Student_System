package com.example.demo.Entities;

import com.example.demo.Utilities.Gender;
import javafx.scene.Group;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    @OneToOne private StudentGroup group;

    protected Student(){}

    public Student(String name, String surname, String dateOfBirth, Gender gender, StudentGroup group) {
        this.name=name;
        this.surname=surname;
        this.dateOfBirth=LocalDate.parse(dateOfBirth,  DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.gender=gender;
        this.group=group;
    }


}
