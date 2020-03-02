package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class StudentGroupDTO {
    private final String name;
    private final String description;
    private List<StudentDTO> students;
}
