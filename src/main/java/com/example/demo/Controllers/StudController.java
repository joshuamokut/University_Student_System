package com.example.demo.Controllers;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.Entities.Student;
import com.example.demo.Mappers.StudentArrayMapper;
import com.example.demo.Services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@AllArgsConstructor
@RestController
@RequestMapping("/students")
public class StudController {
    private final StudentService studentService;
    private final StudentArrayMapper studentArrayMapper;

    @GetMapping("all")
    public ArrayList<StudentDTO> showAllStudents(){
        return studentArrayMapper.MapStudentsToArray(studentService.showAllStudents());
    }

    @GetMapping(value = "/find")
    public ArrayList<StudentDTO> findStudentsByName(@RequestParam(value ="name") String name){
        return studentArrayMapper.MapStudentsToArray(studentService.findStudentsByName(name));
    }

    @GetMapping(value = "/find/adults")
    public ArrayList<StudentDTO> findAdult(){
        return studentArrayMapper.MapStudentsToArray(studentService.findStudentsAboveAge(18));
    }

    @PostMapping("/add")
    public String addNewStudent(@RequestBody ArrayList<Student> students){
        studentService.addNewStudent(students);

        return "New student added successfully";
    }
}
