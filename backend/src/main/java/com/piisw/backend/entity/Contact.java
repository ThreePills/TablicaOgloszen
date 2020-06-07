package com.piisw.backend.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Contact implements Serializable {

  @Id
  @SequenceGenerator(
      name = "CONTACT_ID_GENERATOR",
      sequenceName = "CONTACT_SEQ",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTACT_ID_GENERATOR")
  @EqualsAndHashCode.Exclude
  private Long id;

  @NotNull private String name;

  @NotNull private String email;

  @NotNull private Integer phoneNumber;
}
