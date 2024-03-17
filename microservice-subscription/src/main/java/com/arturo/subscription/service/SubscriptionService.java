package com.arturo.subscription.service;

import com.arturo.subscription.dto.request.SubscriptionResponse;
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

    public List<SubscriptionResponse> findAll(){
        return subscriptionRepository.findAll().stream().map(subscriptionMapper::mapper).toList();
    }
}
