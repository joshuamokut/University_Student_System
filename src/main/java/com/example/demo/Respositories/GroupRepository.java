package com.example.demo.Respositories;

import com.example.demo.Entities.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface GroupRepository extends JpaRepository<StudentGroup, Long> {
    StudentGroup findFirstByName(String name);
    ArrayList<StudentGroup> findAllByName(String name);
}
