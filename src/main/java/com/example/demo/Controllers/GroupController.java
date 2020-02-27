package com.example.demo.Controllers;

import com.example.demo.Entities.StudentGroup;
import com.example.demo.Entities.Student;
import com.example.demo.Services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping(value = "/add")
    public String addGroup(@RequestBody ArrayList<StudentGroup> studentGroup) {

        groupService.addNewGroup(studentGroup);

        return "New student added successfully";

    }

    @GetMapping("/find")
    public ArrayList<StudentGroup> getGroupsByName(@RequestParam(value = "name", defaultValue = "oaken") String name) {
        return groupService.getGroupByName(name);
    }

    @GetMapping("/students")
    public ArrayList<Student> getStudentsInGroup(@RequestParam() String name) {
        return groupService.findStudentsInGroup(name);
    }
}
