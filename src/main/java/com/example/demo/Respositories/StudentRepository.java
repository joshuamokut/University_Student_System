package com.example.demo.Respositories;

import com.example.demo.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public interface StudentRepository extends JpaRepository<Student, Long> {
    ArrayList<Student> findByDateOfBirthBefore(LocalDate date);
    ArrayList<Student> findAllByGroupIdEquals(Long groupId);
    ArrayList<Student> findAllByName(String name);
    ArrayList<Student> findAll();
}
