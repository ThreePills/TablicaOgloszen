package com.piisw.backend.repository;

import com.piisw.backend.entity.Contact;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
  Optional<Contact> findByHashValueEquals(int hashValue);
}
