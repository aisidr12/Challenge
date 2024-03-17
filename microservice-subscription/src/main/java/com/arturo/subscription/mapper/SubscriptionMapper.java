package com.arturo.subscription.mapper;

import com.arturo.subscription.dto.request.SubscriptionRequest;
import com.arturo.subscription.dto.request.SubscriptionResponse;
import com.arturo.subscription.entity.SubscriptionEntity;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionMapper {


    public SubscriptionResponse mapper(SubscriptionEntity entity){
        return SubscriptionResponse.builder()
                .idSubscription(String.valueOf(entity.getIdSubscription()))
                .firstName(entity.getFirstName())
                .email(entity.getEmail())
                .build();
    }


    public SubscriptionEntity mapToEntity(SubscriptionRequest subscriptionRequest){
        return SubscriptionEntity.builder()
                .email(subscriptionRequest.email())
                .firstName(subscriptionRequest.firstName())
                .gender(subscriptionRequest.gender())
                .birth(subscriptionRequest.birth())
                .newsletter(subscriptionRequest.newsletter())
                .newsLetterId(subscriptionRequest.newsLetterId())
                .build();
    }
}
