package com.example.demo.endpoint.rest.controller.health;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
  @Mock private StudentRepository studentRepository;

  @InjectMocks private StudentService studentService;

  @Test
  public void should_return_list_student() {
    Student student1 = Student.builder().id("STD241").firstName("Mioty").lastName("Rah").build();
    Student student2 = Student.builder().id("STD242").firstName("Isaia").lastName("Rabe").build();
    when(studentRepository.findAll()).thenReturn(List.of(student1, student2));

    List<Student> students = studentService.getAllStudent();

    assertThat(students).containsExactly(student1, student2);
  }

  @Test
  public void should_return_student_with_id() {
    Student student = Student.builder().id("STD241").firstName("Mioty").lastName("Rah").build();
    when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));

    Student studentTest = studentService.getStudentById(student.getId());

    assertThat(studentTest).isEqualTo(student);
  }

  @Test
  public void should_create_student_successfully() {
    Student student = Student.builder().id("STD24206").firstName("Mioty").lastName("Rah").build();
    when(studentRepository.save(student)).thenReturn(student);

    Student student1 = studentService.createStudent(student);

    assertThat(student1).isEqualTo(student);
  }
}
