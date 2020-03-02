package com.example.demo.Respositories;

import com.example.demo.Entities.Student;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByDateOfBirthBefore(LocalDate date);
    List<Student> findAllByStudentGroupId(Long groupId);
    List<Student> findAllByName(String name);
    @NotNull
    @Override
    List<Student> findAll();
}
