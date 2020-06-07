package com.piisw.backend.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode (callSuper = false)
public class Localization extends AbstractEntity implements Serializable {

        @NotNull
        private String country;

        @NotNull
        private String region;

        @NotNull
        private String zipCode;

        @NotNull
        private String localizationName;

}
