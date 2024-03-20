package com.arturo.email.controller;

import com.arturo.email.dto.EmailRequest;
import com.arturo.email.dto.EmailResponse;
import com.arturo.email.service.EmailService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/email")
public class EmailController implements EmailUI {

  private final EmailService emailService;

  @Override
  public ResponseEntity<EmailResponse> createEmailSubscription(EmailRequest request) {
    return ResponseEntity.ok(emailService.createEmail(request));
  }

  @Override
  public ResponseEntity<String> cancelEmailSubscription(EmailRequest request) {
    emailService.deleteEmail(request.email());
    return ResponseEntity.ok("SuccessFully Deleted");
  }

  @Override
  public ResponseEntity<EmailResponse> getDetailEmail(String email) {
    return ResponseEntity.ok(emailService.findByEmail(email));
  }

  @Override
  public ResponseEntity<List<EmailResponse>> getSubscriptions() {
    return ResponseEntity.ok(emailService.getAllEmails());
  }
}
