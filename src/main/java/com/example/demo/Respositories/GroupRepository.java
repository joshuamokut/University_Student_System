package com.example.demo.Respositories;

import com.example.demo.Entities.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<StudentGroup, Long> {
    StudentGroup findFirstByName(String name);
    StudentGroup findFirstById(Long id);
    List<StudentGroup> findAllByName(String name);
}
