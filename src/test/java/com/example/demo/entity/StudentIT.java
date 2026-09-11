package com.example.demo.entity;

import com.example.demo.service.StudentService;
import org.junit.jupiter.api.Test;

// While testing , use three AAA : Arrange, Act, Assert
public class StudentIT {

  private final StudentService studentService;

  public StudentIT(StudentService studentService) {
    this.studentService = studentService;
  }

  @Test
  void should_return_students() {
    // Arrange
    Student student = Student.builder().id("STD24201").firstName("Mioty").lastName("Rah").build();
    // Act

  }
}
