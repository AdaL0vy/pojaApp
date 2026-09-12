package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.handler.exception.StudentNotCreatedException;
import com.example.demo.handler.exception.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {

  private StudentRepository studentRepository;

  public List<Student> getAllStudent() {
    return studentRepository.findAll(); // TABLEAU VIDE SI VIDE
  }

  public Student getStudentById(String id) {
    return studentRepository
        .findById(id)
        .orElseThrow(() -> new StudentNotFoundException("Student whith id: " + id + " not found"));
  }

  public Student createStudent(Student student) {
    if (student.getId() == null
        || student.getId().isEmpty()
        || student.getFirstName() == null
        || student.getFirstName().isEmpty()) {
      throw new StudentNotCreatedException("Please fill the request information");
    }
    return studentRepository.save(student);
  }
}
