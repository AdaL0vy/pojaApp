package com.example.demo.endpoint.rest.controller.health;

import com.example.demo.endpoint.event.EventProducer;
import com.example.demo.endpoint.event.model.SendEmailRequested;
import com.example.demo.service.HelloWorldService;
import java.util.List;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  private final EventProducer<SendEmailRequested> eventProducer;
  private final HelloWorldService service;

  public HelloController(
      EventProducer<SendEmailRequested> eventProducer, HelloWorldService service) {
    this.eventProducer = eventProducer;
    this.service = service;
  }

  @GetMapping("/hello")
  @SneakyThrows
  public String HelloWorld(@RequestParam String to, @RequestParam String name) {
    var event = SendEmailRequested.builder().to(to).build();
    eventProducer.accept(List.of(event));
    return "...World!" + service.uploadHelloWorldMessage(name);
  }
}
