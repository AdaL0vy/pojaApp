package com.example.demo.endpoint.rest.controller;

import com.example.demo.endpoint.event.EventProducer;
import com.example.demo.endpoint.event.model.SendEmailStudentCreatedRequest;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {
  private StudentService studentService;
  private final EventProducer<SendEmailStudentCreatedRequest> eventProducer;

  @GetMapping
  public List<Student> studentList() {
    return studentService.getAllStudent();
  }

  @GetMapping("/{id}")
  public Student studentById(@PathVariable String id) {
    return studentService.getStudentById(id);
  }

  @PostMapping
  @SneakyThrows
  public Student saveStudent(@RequestParam String to, String name, @RequestBody Student student) {
    var event = SendEmailStudentCreatedRequest.builder().email(to).firstName(name).build();
    eventProducer.accept(List.of(event));
    return studentService.createStudent(student);
  }
}
