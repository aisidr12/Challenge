package com.arturo.subscription.controller;

import com.arturo.subscription.dto.request.SubscriptionRequest;
import com.arturo.subscription.dto.request.SubscriptionResponse;
import com.arturo.subscription.exception.SubscriptionException;
import com.arturo.subscription.service.SubscriptionService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/subscription")
public class SubscriptionController implements SubscriptionUI {

    private final SubscriptionService subscriptionService;

    @Override
    public ResponseEntity<SubscriptionResponse> createSubscription(
        @Valid @RequestBody SubscriptionRequest request) {
        SubscriptionResponse subscription;
        try {
            subscription = subscriptionService.createSubscription(request);
        } catch (SubscriptionException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(subscription);
    }

    @Override
    public ResponseEntity<SubscriptionResponse> cancelSubscription(
        @RequestBody SubscriptionRequest request) {
        return ResponseEntity.ok(subscriptionService.cancelSubscription(request.idSubscription()));
    }

    @Override
    public ResponseEntity<SubscriptionResponse> getDetailSubscription(Long idSubscription) {
        return ResponseEntity.ok(subscriptionService.getDetail(idSubscription));
    }

    @Override
    public ResponseEntity<List<SubscriptionResponse>> getSubscriptions() {
        return ResponseEntity.ok(subscriptionService.findAll());
    }
}
