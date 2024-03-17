package com.arturo.subscription.controller;

import com.arturo.subscription.dto.request.SubscriptionRequest;
import com.arturo.subscription.dto.request.SubscriptionResponse;
import com.arturo.subscription.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SubscriptionController implements SubscriptionUI {

    private final SubscriptionService subscriptionService;
    @Override
    public ResponseEntity<SubscriptionResponse> createSubscription(SubscriptionRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<SubscriptionResponse> cancelSubscription(SubscriptionRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<SubscriptionResponse> getDetailSubscription(SubscriptionRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<List<SubscriptionResponse>> getSubscriptions() {
        return ResponseEntity.ok(subscriptionService.findAll());
    }
}
