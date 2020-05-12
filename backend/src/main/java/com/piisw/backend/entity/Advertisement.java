package com.piisw.backend.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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

@Entity
@Data
public class Advertisement implements Serializable {

        @Id
        @SequenceGenerator (name = "ADVERTISEMENT_ID_GENERATOR", sequenceName = "ADVERTISEMENT_SEQ", allocationSize = 1)
        @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "ADVERTISEMENT_ID_GENERATOR")
        private Integer id;

        @NotNull
        @Column
        private String title;

        @NotNull
        @Column
        private String content;

        @NotNull
        @Column
        private char isActive;

        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
        @JoinColumn(name = "CONTACT_ID", nullable = false)
        private Contact contact;

        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
        @JoinColumn(name = "LOCALIZATION_ID", nullable = false)
        private Localization localization;

        public Advertisement() {
        }

        public Advertisement(Advertisement advertisement) {
                this.title = advertisement.getTitle();
                this.content = advertisement.getContent();
                this.isActive = 'Y';
                this.contact =  new Contact(advertisement.getContact());
                this.localization = new Localization(advertisement.getLocalization());
        }


}
