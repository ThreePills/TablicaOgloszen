package com.piisw.backend.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Offer extends AbstractEntity implements Serializable {

  @NotNull(message = "Offer title is required")
  @Pattern(regexp = "^[A-Z].*", message = "Offer title first letter should be Upper Case")
  private String title;

  @NotNull(message = "Offer content is required")
  private String content;

  @NotNull private boolean isActive = true;

  @NotNull(message = "Contact details are required")
  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "CONTACT_ID", nullable = false)
  private Contact contact;

  @NotNull(message = "Localization details are required")
  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "LOCALIZATION_ID", nullable = false)
  private Localization localization;
}
