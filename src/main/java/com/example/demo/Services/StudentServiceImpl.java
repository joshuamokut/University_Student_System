package com.example.demo.Services;

import com.example.demo.Entities.Student;
import com.example.demo.Respositories.GroupRepository;
import com.example.demo.Respositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findStudentsByName(String name) {
        return studentRepository.findAllByName(name);
    }

    @Override
    public List<Student> findStudentsAboveAge(int age) {
        return studentRepository.findByDateOfBirthBefore(LocalDate.now().minusYears(age));
    }

    @Override
    public List<Student> showAllStudents() {
        return studentRepository.findAll();
    }
}
