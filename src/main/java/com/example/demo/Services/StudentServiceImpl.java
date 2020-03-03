package com.example.demo.Services;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.Entities.Student;
import com.example.demo.Entities.StudentGroup;
import com.example.demo.Mappers.StudentMapper;
import com.example.demo.Respositories.GroupRepository;
import com.example.demo.Respositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {


    private StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final GroupRepository groupRepository;
    @Override
    public void addNewStudent(List<Student> students) {
        students.forEach(student -> student.setStudentGroup(groupRepository.findFirstByName(student.getStudentGroupName())));
        studentRepository.saveAll(students);
    }

    @Override
    public List<StudentDTO> findStudentsByName(String name) {
        return studentMapper.mapStudentsToDTOArray(studentRepository.findAllByName(name));
    }

    @Override
    public List<StudentDTO> findStudentsAboveAge(int age) {
        return studentMapper.mapStudentsToDTOArray(studentRepository.findByDateOfBirthBefore(LocalDate.now().minusYears(age)));
    }

    @Override
    public List<StudentDTO> showAllStudents() {
        return studentMapper.mapStudentsToDTOArray(studentRepository.findAll());
    }
}
