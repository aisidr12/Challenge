package com.arturo.subscription.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;

@Builder
@JsonIgnoreProperties
public record SubscriptionRequest(Long idSubscription,
                                  String email,
                                  String firstName,
                                  String gender,
                                  String birth,
                                  boolean newsletter,
                                  String newsLetterId) {

}
