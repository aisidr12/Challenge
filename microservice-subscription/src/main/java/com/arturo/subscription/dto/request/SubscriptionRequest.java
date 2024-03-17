package com.arturo.subscription.dto.request;

import lombok.Builder;

@Builder
public record SubscriptionRequest(Long idSubscription,
                                  String email,
                                  String firstName,
                                  String gender,
                                  String birth,
                                  boolean newsletter,
                                  String newsLetterId) {

}
