package com.example.demo.Entities;

import com.example.demo.Utilities.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Long groupId;

    protected Student(){}

    public Student(String name, String surname, String dateOfBirth, Gender gender, Long groupId) {
        this.name=name;
        this.surname=surname;
        this.dateOfBirth=LocalDate.parse(dateOfBirth,  DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.gender=gender;
        this.groupId=groupId;
    }


}
