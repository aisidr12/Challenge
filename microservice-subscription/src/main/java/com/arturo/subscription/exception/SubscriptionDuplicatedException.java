package com.arturo.subscription.exception;

public class SubscriptionDuplicatedException extends RuntimeException {


  public SubscriptionDuplicatedException(String message) {
    super(message);
  }
}
