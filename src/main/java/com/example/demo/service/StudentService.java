package com.example.demo.service;


import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;


    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getStudentById(String id){
        return studentRepository.getReferenceById(id);
    }

}
