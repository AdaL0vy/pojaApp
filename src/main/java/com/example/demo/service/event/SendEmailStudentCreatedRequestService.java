package com.example.demo.service.event;

import com.example.demo.endpoint.event.model.SendEmailStudentCreatedRequest;
import com.example.demo.mail.Email;
import com.example.demo.mail.Mailer;
import jakarta.mail.internet.InternetAddress;
import java.util.List;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SendEmailStudentCreatedRequestService
    implements Consumer<SendEmailStudentCreatedRequest> {
  private final Mailer mailer;

  @SneakyThrows
  @Override
  public void accept(SendEmailStudentCreatedRequest sendEmailStudentCreatedRequest) {
    var recipientAddress = new InternetAddress(sendEmailStudentCreatedRequest.getEmail());
    mailer.accept(
        new Email(
            recipientAddress,
            List.of(),
            List.of(),
            "Student Registered",
            "Good Morning "
                + sendEmailStudentCreatedRequest.getFirstName()
                + " Your information has been successfully registered",
            List.of()));
  }
}
