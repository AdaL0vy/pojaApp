package com.example.demo.handler.exception;

public class NoStudentInTheDatabaseException extends RuntimeException {
  public NoStudentInTheDatabaseException(String message) {
    super(message);
  }
}
