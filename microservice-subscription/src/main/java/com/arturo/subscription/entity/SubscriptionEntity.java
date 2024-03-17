package com.arturo.subscription.entity;

import jakarta.persistence.*;
import lombok.*;

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