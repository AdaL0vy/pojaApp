package com.example.demo.endpoint.rest.controller.health;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
  private StudentService studentService;

  @GetMapping("/students")
  public Student studentById(@PathVariable String id) {
    return studentService.getStudentById(id);
  }
}
