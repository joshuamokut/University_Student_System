package com.example.demo.Respositories;

import com.example.demo.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByDateOfBirthBefore(LocalDate date);
    List<Student> findAllByGroupIdEquals(Long groupId);
    List<Student> findAllByName(String name);

}
