package com.example.demo.Controllers;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.Entities.StudentGroup;
import com.example.demo.Entities.Student;
import com.example.demo.Mappers.StudentArrayMapper;
import com.example.demo.Services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@AllArgsConstructor
@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;
    private final StudentArrayMapper studentArrayMapper;

    @PostMapping(value = "/add")
    public String addGroup(@RequestBody ArrayList<StudentGroup> studentGroup) {

        groupService.addNewGroup(studentGroup);

        return "New student added successfully";

    }

    @GetMapping("/find")
    public ArrayList<StudentGroup> getGroupsByName(@RequestParam String name) {
        return groupService.getGroupByName(name);
    }

    @GetMapping("/students")
    public ArrayList<StudentDTO> getStudentsInGroup(@RequestParam String name) {
        return studentArrayMapper.MapStudentsToArray(groupService.findStudentsInGroup(name));
    }
}
