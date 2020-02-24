package com.example.demo.Controllers;

import com.example.demo.Entities.Student;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Stud")
public class StudController {
    private final StudentService studentService;

    @Autowired
    public StudController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/find", produces = "application/json")
    public List<Student> findStudentsByName(@RequestParam(value ="name") String name){
        return studentService.findStudentsByName(name);
    }

    @GetMapping(value = "/find/adults", produces = "application/json")
    public List<Student> findAdult(){
        return studentService.findStudentsAboveAge(18);
    }

    @PostMapping("/add")
    public void addNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
}
