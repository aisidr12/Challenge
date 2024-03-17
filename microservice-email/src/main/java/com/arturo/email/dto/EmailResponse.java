package com.arturo.email.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class EmailResponse {

  private Long emailId;
  private String email;
  private String firstName;
  private String gender;
  private String birth;
  private boolean newsLetter;
  private String newsLetterId;
}