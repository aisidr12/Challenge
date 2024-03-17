package com.arturo.subscription.service;

import com.arturo.subscription.dto.request.SubscriptionRequest;
import com.arturo.subscription.dto.request.SubscriptionResponse;
import com.arturo.subscription.entity.SubscriptionEntity;
import com.arturo.subscription.mapper.SubscriptionMapper;
import com.arturo.subscription.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;


    public SubscriptionResponse createSubscription(SubscriptionRequest subscriptionRequest) {
        return subscriptionMapper.mapper(subscriptionRepository.save(requestToEntity(subscriptionRequest)));
    }

    private SubscriptionEntity requestToEntity(SubscriptionRequest subscriptionRequest) {
        return subscriptionMapper.mapToEntity(subscriptionRequest);
    }

    public List<SubscriptionResponse> findAll() {
        return subscriptionRepository.findAll().stream().map(subscriptionMapper::mapper).toList();
    }

    public SubscriptionResponse getDetail(Long idSubscription) {
        return subscriptionRepository.findById(idSubscription).map(subscriptionMapper::mapper).orElse(SubscriptionResponse.builder().build());
    }

    public SubscriptionResponse cancelSubscription(Long idSubscription) {
        subscriptionRepository.deleteById(idSubscription);
        return SubscriptionResponse.builder()
                .response("Subscription Cancelled successfully")
                .build();
    }
}
