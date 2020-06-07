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
@EqualsAndHashCode (callSuper = false)
public class Contact extends AbstractEntity implements Serializable {

        @NotNull (message = "Contact name is required")
        @Pattern (regexp = "^[A-Z].*", message = "Contact name first letter should be Upper Case")
        private String name;

        @NotNull (message = "Contact name is required")
        @Pattern (regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"" +
                           "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b" +
                           "\\x0c\\x0e" +
                           "-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])" +
                           "?|\\[(?:" +
                           "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" +
                           "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:" +
                           "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c" +
                           "\\x0e-\\x7f])" +
                           "+)\\])", message = "Email field is not valid")
        private String email;


        @NotNull (message = "Contact phone number is required")
        private Integer phoneNumber;

}
