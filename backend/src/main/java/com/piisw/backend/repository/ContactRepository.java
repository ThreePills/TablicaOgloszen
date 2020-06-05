package com.piisw.backend.repository;

import java.util.List;

import com.piisw.backend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
        List<Contact> findAll();
}
