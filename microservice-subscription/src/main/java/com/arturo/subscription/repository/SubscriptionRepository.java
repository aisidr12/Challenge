package com.arturo.subscription.repository;

import com.arturo.subscription.entity.SubscriptionEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity,Long> {

  Optional<SubscriptionEntity> findByEmail(String email);
}
