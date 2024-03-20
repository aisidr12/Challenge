package com.arturo.subscription.service;

import com.arturo.subscription.dto.request.SubscriptionRequest;
import com.arturo.subscription.dto.request.SubscriptionResponse;
import com.arturo.subscription.entity.SubscriptionEntity;
import com.arturo.subscription.exception.SubscriptionDuplicatedException;
import com.arturo.subscription.exception.SubscriptionException;
import com.arturo.subscription.exception.SubscriptionNotFoundException;
import com.arturo.subscription.mapper.SubscriptionMapper;
import com.arturo.subscription.repository.SubscriptionRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;

    public SubscriptionResponse createSubscription(SubscriptionRequest subscriptionRequest) throws SubscriptionException{
        validateEmail(subscriptionRequest);
        return subscriptionMapper.mapper(
            subscriptionRepository.save(requestToEntity(subscriptionRequest)));
    }

    public List<SubscriptionResponse> findAll() {
        return subscriptionRepository.findAll().stream().map(subscriptionMapper::mapper).collect(
            Collectors.toList());
    }

    public SubscriptionResponse getDetail(Long idSubscription) {
        SubscriptionEntity subscriptionEntity = subscriptionRepository.findById(idSubscription)
            .orElseThrow(() -> new SubscriptionNotFoundException("Subscription not found"));
        return subscriptionMapper.mapper(subscriptionEntity);
    }

    public SubscriptionResponse cancelSubscription(Long idSubscription) {
        subscriptionRepository.findById(idSubscription).orElseThrow(()-> new SubscriptionNotFoundException("Id Subscription not Found, please check and try again"));
        subscriptionRepository.deleteById(idSubscription);
        return SubscriptionResponse.builder()
            .response("Subscription Cancelled successfully")
            .build();
    }


    private SubscriptionEntity requestToEntity(SubscriptionRequest subscriptionRequest) {
        return subscriptionMapper.mapToEntity(subscriptionRequest);
    }

    private void validateEmail(SubscriptionRequest subscriptionRequest){
        log.info("Checking email " + subscriptionRequest.email());
        subscriptionRepository.findByEmail(subscriptionRequest.email()).ifPresent(request  -> {
            log.info("Email already registered "+ request.getEmail());
            throw new SubscriptionDuplicatedException("Email already registered "+ request.getEmail());
        });
    }



}
