package com.arturo.subscription.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "subscription")
@Builder
@AllArgsConstructor
public class SubscriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubscription;
    @Column
    private String email;
    @Column
    private String firstName;
    @Column
    private String gender;
    @Column
    private String birth;
    @Column
    private boolean newsletter;
    @Column
    private String newsLetterId;


    public SubscriptionEntity() {

    }
}