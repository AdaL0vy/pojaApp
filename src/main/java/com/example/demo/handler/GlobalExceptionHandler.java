package com.example.demo.handler;

import com.example.demo.handler.exception.StudentNotCreatedException;
import com.example.demo.handler.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(StudentNotFoundException.class)
  public ResponseEntity<ErrorResponse> notFoundStudent(StudentNotFoundException ex) {
    ErrorResponse errorResponse =
        ErrorResponse.create(ex, HttpStatus.NOT_FOUND, "Student not found");
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }

  @ExceptionHandler(StudentNotCreatedException.class)
  public ResponseEntity<ErrorResponse> notCreatedStudent(StudentNotCreatedException ex) {
    ErrorResponse errorResponse =
        ErrorResponse.create(ex, HttpStatus.FORBIDDEN, "Student not created");
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponse);
  }
}
