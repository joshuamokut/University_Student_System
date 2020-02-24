package com.example.demo.Controllers;

import com.example.demo.Entities.Group;
import com.example.demo.Entities.Student;
import com.example.demo.Services.GroupServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupServices groupServices;

    @Autowired
    public GroupController(GroupServices groupServices) {
        this.groupServices=groupServices;
    }

    @PostMapping(value = "/addGroup", consumes = "application/json")
    public void addGroup(@RequestBody Group group){
        groupServices.addNewGroup(group);
    }

    public List<Group> getGroupsByName(@RequestParam String name){
        return groupServices.getGroupByName(name);
    }

    @GetMapping("/getStudents")
    public List<Student> getStudentsInGroup(@RequestParam String name){
        return groupServices.findStudentsInGroup(name);
    }
}
