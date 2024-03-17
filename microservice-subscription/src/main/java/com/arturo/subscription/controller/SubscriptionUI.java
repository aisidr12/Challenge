package com.arturo.subscription.controller;

import com.arturo.subscription.dto.request.SubscriptionRequest;
import com.arturo.subscription.dto.request.SubscriptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface SubscriptionUI {

    @PostMapping("/create")
    ResponseEntity<SubscriptionResponse> createSubscription(SubscriptionRequest request);

    @PostMapping("/cancel")
    ResponseEntity<SubscriptionResponse> cancelSubscription(SubscriptionRequest request);

    @GetMapping("/details")
    ResponseEntity<SubscriptionResponse> getDetailSubscription(SubscriptionRequest request);

    @GetMapping("/subscriptions")
    ResponseEntity<List<SubscriptionResponse>> getSubscriptions();
}