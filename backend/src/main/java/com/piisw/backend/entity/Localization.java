package com.piisw.backend.entity;

import java.io.Serializable;

import javax.persistence.Entity;
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
public class Localization extends AbstractEntity implements Serializable {

  @NotNull(message = "Localization country is required")
  @Pattern(regexp = "^[A-Z].*", message = "Localization country first letter should be Upper Case")
  private String country;

  @NotNull(message = "Localization region is required")
  @Pattern(regexp = "^[A-Z].*", message = "Localization region first letter should be Upper Case")
  private String region;

  @NotNull(message = "Localization zip-code is required")
  @Pattern(
      regexp = "(\\d{2})([-])(\\d{3})",
      message = "Localization zip-code should be in format XX-XXX")
  private String zipCode;

  @NotNull(message = "Localization name is required")
  @Pattern(regexp = "^[A-Z].*", message = "Localization name first letter should be Upper Case")
  private String localizationName;
}
