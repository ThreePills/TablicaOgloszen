package com.piisw.backend.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Advertisement implements Serializable {

        @Id
        @SequenceGenerator (name = "ADVERTISEMENT_ID_GENERATOR", sequenceName = "ADVERTISEMENT_SEQ", allocationSize = 1)
        @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "ADVERTISEMENT_ID_GENERATOR")
        private Integer id;

        @NotNull
        private String title;

        @NotNull
        private String content;

        @NotNull
        private boolean isActive;

        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
        @JoinColumn(name = "CONTACT_ID", nullable = false)
        private Contact contact;

        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
        @JoinColumn(name = "LOCALIZATION_ID", nullable = false)
        private Localization localization;

        public Advertisement(Advertisement advertisement) {
                this.title = advertisement.getTitle();
                this.content = advertisement.getContent();
                this.isActive = true;
                this.contact =  advertisement.getContact();
                this.localization = advertisement.getLocalization();
        }


}
