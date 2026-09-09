package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private StudentRepository studentRepository;

  public List<Student> getAllStudent() {
    return studentRepository.findAll();
  }

  public Student getStudentById(String id) {
    return studentRepository.getReferenceById(id);
  }
}
