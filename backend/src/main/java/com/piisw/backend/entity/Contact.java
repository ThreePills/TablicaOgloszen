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
public class Contact implements Serializable {

        public Contact() {}

        public Contact(Contact contact) {
                this.name = contact.getName();
                this.email = contact.getName();
                this.phoneNumber =contact.getPhoneNumber();
        }

        @Id
        @SequenceGenerator (name = "CONTACT_ID_GENERATOR", sequenceName = "CONTACT_SEQ", allocationSize = 1)
        @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "CONTACT_ID_GENERATOR")
        private Integer id;

        @NotNull
        @Column
        private String name;

        @NotNull
        @Column
        private String email;

        @NotNull
        @Column
        private Integer phoneNumber;


}
