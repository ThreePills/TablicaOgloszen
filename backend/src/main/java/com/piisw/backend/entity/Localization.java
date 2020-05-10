package com.piisw.backend.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Localization implements Serializable {

        public Localization() {}

        @Id
        @SequenceGenerator (name = "LOCALIZATIION_ID_GENERATOR", sequenceName = "LOCALIZATION_SEQ", allocationSize = 1)
        @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "LOCALIZATION_ID_GENERATOR")
        private Integer id;

        @NotNull
        @Column
        private String country;

        @NotNull
        @Column
        private String region;

        @NotNull
        @Column
        private String zipCode;

        @NotNull
        @Column
        private String localizationName;

}
