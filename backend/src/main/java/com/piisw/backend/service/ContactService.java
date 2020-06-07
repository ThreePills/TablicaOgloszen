package com.piisw.backend.service;

import com.piisw.backend.entity.Contact;
import com.piisw.backend.repository.ContactRepository;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

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
