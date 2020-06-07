package com.piisw.backend.service;

import java.util.Optional;
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
                return contactRepository.findAll().stream()
                                        .filter(contact -> contact.equals(offerContact))
                                        .findFirst().orElseGet(() -> contactRepository.save(offerContact));
        }

        Optional<Contact> findById(Long id) {
                return contactRepository.findById(id);
        }
}
