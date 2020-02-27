package com.example.demo.Controllers;

import com.example.demo.Entities.Student;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/students")
public class StudController {
    private final StudentService studentService;

    @Autowired
    public StudController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("all")
    public ArrayList<Student> showAllStudents(){
        return studentService.showAllStudents();
    }

    @GetMapping(value = "/find")
    public ArrayList<Student> findStudentsByName(@RequestParam(value ="name") String name){
        return studentService.findStudentsByName(name);
    }

    @GetMapping(value = "/find/adults")
    public ArrayList<Student> findAdult(){
        return studentService.findStudentsAboveAge(18);
    }

    @PostMapping("/add")
    public String addNewStudent(@RequestBody ArrayList<Student> students){
        studentService.addNewStudent(students);

        return "New student added successfully";
    }
}
