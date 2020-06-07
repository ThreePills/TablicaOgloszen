package com.piisw.backend.service;

import com.piisw.backend.entity.Contact;
import com.piisw.backend.repository.ContactRepository;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ContactService {

  private final ContactRepository contactRepository;

  Contact upadateContactInOffer(Contact offerContact) {
    Optional<Contact> contactOptional =
        contactRepository.findAll().stream()
            .filter(contact -> contact.equals(offerContact))
            .findFirst();

    return contactOptional.orElseGet(() -> contactRepository.save(offerContact));
  }
}
