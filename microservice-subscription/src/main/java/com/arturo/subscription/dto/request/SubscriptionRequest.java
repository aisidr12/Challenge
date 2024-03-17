package com.arturo.subscription.dto.request;

import lombok.Builder;

@Builder
public class SubscriptionRequest {
    private String email;
    private String firstName;
    private String gender;
    private String birth;
    private boolean newsletter;
    private String newsLetterId;
}
