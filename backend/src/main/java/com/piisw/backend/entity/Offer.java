package com.piisw.backend.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Offer extends AbstractEntity implements Serializable {

        @NotNull
        private String title;

        @NotNull
        private String content;

        @NotNull
        private boolean isActive = true;

        @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
        @JoinColumn (name = "CONTACT_ID", nullable = false)
        private Contact contact;

        @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
        @JoinColumn (name = "LOCALIZATION_ID", nullable = false)
        private Localization localization;

}
