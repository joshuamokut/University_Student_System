package com.example.demo.Controllers;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.DTO.StudentGroupDTO;
import com.example.demo.Entities.StudentGroup;
import com.example.demo.Mappers.StudentMapper;
import com.example.demo.Services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    @PostMapping(value = "/add")
    public String addGroup(@RequestBody List<StudentGroup> studentGroup) {

        groupService.addNewGroup(studentGroup);

        return "New group added successfully";

    }

    @GetMapping("/find")
    public List<StudentGroupDTO> getGroupsByName(@RequestParam String name) {
        return groupService.getGroupByName(name);
    }

    @GetMapping("/students")
    public List<StudentDTO> getStudentsInGroup(@RequestParam String name) {
        return groupService.findStudentsInGroup(name);
    }

    @GetMapping("/all")
    public List<StudentGroupDTO> getAll(){
        return groupService.showAllGroups();
    }
}
