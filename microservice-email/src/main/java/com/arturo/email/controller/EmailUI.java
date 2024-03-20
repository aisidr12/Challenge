package com.arturo.email.controller;

import com.arturo.email.dto.EmailRequest;
import com.arturo.email.dto.EmailResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface EmailUI {

  @PostMapping("/create")
  ResponseEntity<EmailResponse> createEmailSubscription(@RequestBody EmailRequest request);

  @PostMapping("/cancel")
  ResponseEntity<String> cancelEmailSubscription(@RequestBody EmailRequest request);

  @GetMapping("/details/{email}")
  ResponseEntity<EmailResponse> getDetailEmail(@PathVariable String email);

  @GetMapping("/emails")
  ResponseEntity<List<EmailResponse>> getSubscriptions();

}
