package com.arturo.email.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "email")
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idEmail;
  @Column(unique = true)
  private String email;
  @Column
  private String firstName;
  @Column
  private String gender;
  @Column
//  @DateTimeFormat(pattern = "DD-MM-YYYY")
  private String birthDay;
  @Column
  private boolean newsletter;
  @Column
  private String newsLetterId;


}
