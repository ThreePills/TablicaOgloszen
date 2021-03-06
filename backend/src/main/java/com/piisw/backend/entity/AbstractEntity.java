package com.piisw.backend.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@NoArgsConstructor
@SuperBuilder
@Data
public abstract class AbstractEntity implements Serializable {
  @Id
  @SequenceGenerator(name = "ID_GENERATOR", sequenceName = "ID_SEQ", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GENERATOR")
  @EqualsAndHashCode.Exclude
  private Long id;

  @CreatedDate @EqualsAndHashCode.Exclude private Instant createdDate;

  @LastModifiedDate @EqualsAndHashCode.Exclude private Instant modifiedDate;

  @Version @EqualsAndHashCode.Exclude private Long version;

  @EqualsAndHashCode.Exclude private int hashValue;

  @PrePersist
  protected void onCreation() {
    createdDate = Instant.now();
    modifiedDate = createdDate;
    hashValue = this.hashCode();
  }

  @PreUpdate
  protected void onUpdate() {
    modifiedDate = Instant.now();
  }

  @PostUpdate
  protected void postUpdate() {
    hashValue = this.hashCode();
  }
}
