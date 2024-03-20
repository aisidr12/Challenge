package com.arturo.subscription.exception.ControllerAdvice;

import com.arturo.subscription.dto.request.ErrorMessage;
import com.arturo.subscription.exception.SubscriptionDuplicatedException;
import com.arturo.subscription.exception.SubscriptionNotFoundException;
import jakarta.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SubscriptionControllerAdvice extends ResponseEntityExceptionHandler {

  @ExceptionHandler(SubscriptionNotFoundException.class)
  public ResponseEntity<ErrorMessage> handlerNotFound(
      final SubscriptionNotFoundException notFoundException) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ErrorMessage(notFoundException.getMessage(), new Date()));
  }

  @ExceptionHandler(SubscriptionDuplicatedException.class)
  public ResponseEntity<ErrorMessage> handlerDuplicated(
      final SubscriptionDuplicatedException duplicatedException) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new ErrorMessage(duplicatedException.getMessage(), new Date()));
  }


  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorMessage> handlerConstraint(
      final ConstraintViolationException constraintViolationException) {
    String errorMessage = new ArrayList<>(
        constraintViolationException.getConstraintViolations()).get(0).getMessage();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new ErrorMessage(errorMessage, new Date()));
  }


}