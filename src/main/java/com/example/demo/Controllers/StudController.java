package com.example.demo.Controllers;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.Entities.Student;
import com.example.demo.Mappers.StudentMapper;
import com.example.demo.Services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/students")
public class StudController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @GetMapping("all")
    public List<StudentDTO> showAllStudents(){
        return studentMapper.MapStudentsToArray(studentService.showAllStudents());
    }

    @GetMapping(value = "/find")
    public List<StudentDTO> findStudentsByName(@RequestParam(value ="name") String name){
        return studentMapper.MapStudentsToArray(studentService.findStudentsByName(name));
    }

    @GetMapping(value = "/find/adults")
    public List<StudentDTO> findAdult(){
        return studentMapper.MapStudentsToArray(studentService.findStudentsAboveAge(18));
    }

    @PostMapping("/add")
    public String addNewStudent(@RequestBody List<Student> students){
        studentService.addNewStudent(students);

        return "New student added successfully";
    }
}
