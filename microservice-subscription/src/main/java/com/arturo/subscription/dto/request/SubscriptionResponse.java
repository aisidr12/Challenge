package com.arturo.subscription.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class SubscriptionResponse {

  private Long idSubscription;
  private String email;
  private String firstName;
  private String gender;
  private String birth;
  private Boolean newsletter;
  private String newsLetterId;
  private String response;
}
