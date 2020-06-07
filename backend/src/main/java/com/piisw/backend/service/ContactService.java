package com.piisw.backend.service;

import javax.transaction.Transactional;

import com.piisw.backend.entity.Contact;
import com.piisw.backend.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Transactional
public class ContactService {

  private final ContactRepository contactRepository;

  Contact saveNewContactIfDoesntExists(Contact offerContact) {
    return contactRepository
        .findByHashValueEquals(offerContact.hashCode())
        .orElseGet(() -> contactRepository.save(offerContact));
  }
}
