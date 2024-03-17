package com.arturo.subscription.mapper;

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
}
