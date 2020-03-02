package com.example.demo.DTO;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class StudentGroupDTO {
    private final String name;
    private final String description;
    private List<StudentDTO> students;
}
