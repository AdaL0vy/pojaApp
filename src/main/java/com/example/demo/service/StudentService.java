package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.handler.exception.NoStudentInTheDatabaseException;
import com.example.demo.handler.exception.StudentNotCreatedException;
import com.example.demo.handler.exception.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private StudentRepository studentRepository;

  public List<Student> getAllStudent() {
    if (studentRepository.findAll().isEmpty()) {
      throw new NoStudentInTheDatabaseException("No student in the database");
    }
    return studentRepository.findAll();
  }

  public Student getStudentById(String id) {
    return studentRepository
        .findById(id)
        .orElseThrow(() -> new StudentNotFoundException("Student whith id: " + id + " not found"));
  }

  public Student createStudent(Student student) {
    if (student.id.isEmpty() || student.firstName.isEmpty()) {
      throw new StudentNotCreatedException("Please fill the request information");
    }
    return studentRepository.save(student);
  }
}
