package com.example.demo.endpoint.rest.controller.health;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {
  private StudentService studentService;

  @GetMapping
  public List<Student> studentList() {
    return studentService.getAllStudent();
  }

  @GetMapping("/{id}")
  public Student studentById(@PathVariable String id) {
    return studentService.getStudentById(id);
  }

  @PostMapping
  public Student saveStudent(@RequestBody Student student) {
    return studentService.createStudent(student);
  }
}
