package com.arturo.subscription.dto.request;

import lombok.Builder;

@Builder
public class SubscriptionResponse {
    private String idSubscription;
    private String email;
    private String firstName;
    private String gender;
    private String birth;
    private boolean newsletter;
    private String newsLetterId;
}
