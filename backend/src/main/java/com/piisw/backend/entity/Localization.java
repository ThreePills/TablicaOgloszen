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
public class Localization implements Serializable {

        @Id
        @SequenceGenerator (name = "LOCALIZATIION_ID_GENERATOR", sequenceName = "LOCALIZATION_SEQ", allocationSize = 1)
        @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "LOCALIZATION_ID_GENERATOR")
        @EqualsAndHashCode.Exclude
        private Long id;

        @NotNull
        private String country;

        @NotNull
        private String region;

        @NotNull
        private String zipCode;

        @NotNull
        private String localizationName;

}
