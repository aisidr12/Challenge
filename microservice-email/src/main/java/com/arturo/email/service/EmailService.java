package com.arturo.email.service;

import com.arturo.email.dto.EmailRequest;
import com.arturo.email.dto.EmailResponse;
import com.arturo.email.entity.EmailEntity;
import com.arturo.email.mapper.EmailMapper;
import com.arturo.email.repository.EmailRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

  private final EmailRepository emailRepository;
  private final EmailMapper emailMapper;

  public List<EmailResponse> getAllEmails() {
    return emailRepository.findAll().stream().map(emailMapper::mapper).toList();
  }

  public EmailResponse createEmail(EmailRequest emailRequest) {
    return emailMapper.mapper(emailRepository.save(emailMapper.mapToEntity(emailRequest)));
  }

  public EmailResponse findByEmail(String email) {
    Optional<EmailEntity> emailOptional = emailRepository.findByEmail(email);
    return emailOptional.isPresent() ?
        emailMapper.mapper(emailOptional.get())
        : EmailResponse.builder()
            .build();
  }

  public void deleteEmail(String email){
    emailRepository.findByEmail(email).ifPresent(emailRepository::delete);
  }
}
