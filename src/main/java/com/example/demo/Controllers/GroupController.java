package com.example.demo.Controllers;

import com.example.demo.Entities.StudentGroup;
import com.example.demo.Entities.Student;
import com.example.demo.Services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping(value = "/addGroup", consumes = "application/json")
    public String addGroup(@RequestBody StudentGroup studentGroup) {
        groupService.addNewGroup(studentGroup);

        return "New student added successfully";

    }

    @GetMapping("/byName")
    public List<StudentGroup> getGroupsByName(@RequestParam(value = "name", defaultValue = "oaken") String name) {
        return groupService.getGroupByName(name);
    }

    @GetMapping("/getStudents")
    public List<Student> getStudentsInGroup(@RequestParam() String name) {
        return groupService.findStudentsInGroup(name);
    }
}
