package com.example.demo.Services;

import com.example.demo.Entities.Student;
import com.example.demo.Respositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {


    private StudentRepository studentRepository;

    @Override
    public void addNewStudent(ArrayList<Student> students) {
        for(Student student: students) {
            studentRepository.save(student);
        }
    }

    @Override
    public ArrayList<Student> findStudentsByName(String name) {
        return studentRepository.findAllByName(name);
    }

    @Override
    public ArrayList<Student> findStudentsAboveAge(int age) {
        return studentRepository.findByDateOfBirthBefore(LocalDate.now().minusYears(age));
    }

    @Override
    public ArrayList<Student> showAllStudents() {
        return studentRepository.findAll();
    }
}
