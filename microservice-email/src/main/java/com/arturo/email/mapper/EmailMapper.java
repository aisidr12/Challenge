package com.arturo.email.mapper;

import com.arturo.email.dto.EmailRequest;
import com.arturo.email.dto.EmailResponse;
import com.arturo.email.entity.EmailEntity;
import org.springframework.stereotype.Component;

@Component
public class EmailMapper {

  public EmailResponse mapper(EmailEntity entity) {
    return EmailResponse.builder()
        .emailId(entity.getIdEmail())
        .email(entity.getEmail())
        .gender(entity.getGender())
        .birth(entity.getBirthDay())
        .newsLetter(entity.isNewsletter())
        .newsLetterId(entity.getNewsLetterId())
        .build();
  }

  public EmailEntity mapToEntity(EmailRequest emailRequest) {
    return EmailEntity.builder()
        .email(emailRequest.email())
        .firstName(emailRequest.firstName())
        .gender(emailRequest.gender())
        .birthDay(emailRequest.birth())
        .newsletter(emailRequest.newsletter())
        .newsLetterId(emailRequest.newsLetterId())
        .build();
  }
}