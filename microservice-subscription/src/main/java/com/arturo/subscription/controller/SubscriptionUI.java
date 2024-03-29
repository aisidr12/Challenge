package com.arturo.subscription.controller;

import com.arturo.subscription.dto.request.SubscriptionRequest;
import com.arturo.subscription.dto.request.SubscriptionResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface SubscriptionUI {

    @PostMapping("/create")
    ResponseEntity<SubscriptionResponse> createSubscription(SubscriptionRequest request);

    @PostMapping("/cancel")
    ResponseEntity<SubscriptionResponse> cancelSubscription(SubscriptionRequest request);

    @GetMapping("/details/{idSubscription}")
    ResponseEntity<SubscriptionResponse> getDetailSubscription(@PathVariable Long idSubscription);

    @GetMapping("/subscriptions")
    ResponseEntity<List<SubscriptionResponse>> getSubscriptions();
}