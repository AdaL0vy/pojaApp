package com.example.demo.endpoint.rest.controller.health;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import jakarta.persistence.Id;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    public void should_return_list_student(){
        Student student1 = Student.builder().id("STD241").firstName("Mioty").lastName("Rah").build();
        Student student2 = Student.builder().id("STD242").firstName("Isaia").lastName("Rabe").build();
        when(studentRepository.findAll()).thenReturn(List.of(student1,student2));

        List<Student> students = studentService.getAllStudent();

        assertThat(students).containsExactly(student1, student2);






    }
}
