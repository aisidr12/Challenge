package com.arturo.subscription.controller;

import com.arturo.subscription.dto.request.SubscriptionRequest;
import com.arturo.subscription.dto.request.SubscriptionResponse;
import com.arturo.subscription.service.SubscriptionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SubscriptionController implements SubscriptionUI {

    private final SubscriptionService subscriptionService;

    @Override
    public ResponseEntity<SubscriptionResponse> createSubscription(SubscriptionRequest request) {
        return ResponseEntity.ok(subscriptionService.createSubscription(request));
    }

    @Override
    public ResponseEntity<SubscriptionResponse> cancelSubscription(SubscriptionRequest request) {
        return ResponseEntity.ok(subscriptionService.cancelSubscription(request.idSubscription()));
    }

    @Override
    public ResponseEntity<SubscriptionResponse> getDetailSubscription(SubscriptionRequest request) {
        return ResponseEntity.ok(subscriptionService.getDetail(request.idSubscription()));
    }

    @Override
    public ResponseEntity<List<SubscriptionResponse>> getSubscriptions() {
        return ResponseEntity.ok(subscriptionService.findAll());
    }
}
