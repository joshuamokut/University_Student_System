package com.example.demo.Respositories;

import com.example.demo.Entities.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<StudentGroup, Long> {
    StudentGroup findFirstByName(String name);

    List<StudentGroup> findAllByName(String name);
}
