package com.arturo.email.repository;

import com.arturo.email.entity.EmailEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailEntity,Long> {

  Optional<EmailEntity> findByEmail(String email);

}
