package com.example.demo.endpoint.rest.controller.health;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelloControllerTest {

  @Test
  void hello() {
    assertEquals("...World!!!", new HelloController().HelloWorld());
  }
}
