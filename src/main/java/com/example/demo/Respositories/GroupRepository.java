package com.example.demo.Respositories;

import com.example.demo.Entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findGroupByNameIs(String name);
}
