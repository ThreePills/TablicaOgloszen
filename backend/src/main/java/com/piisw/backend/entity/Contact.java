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
public class Contact extends AbstractEntity implements Serializable {

        @NotNull
        private String name;

        @NotNull
        private String email;

        @NotNull
        private Integer phoneNumber;

}
