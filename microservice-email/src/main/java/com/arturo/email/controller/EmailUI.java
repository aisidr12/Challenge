package com.arturo.email.controller;

import com.arturo.email.dto.EmailRequest;
import com.arturo.email.dto.EmailResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface EmailUI {

  @PostMapping("/create")
  ResponseEntity<EmailResponse> createEmailSubscription(EmailRequest request);

  @PostMapping("/cancel")
  ResponseEntity<String> cancelEmailSubscription(EmailRequest request);

  @GetMapping("/details")
  ResponseEntity<EmailResponse> getDetailEmail(EmailRequest request);

  @GetMapping("/emails")
  ResponseEntity<List<EmailResponse>> getSubscriptions();

}
