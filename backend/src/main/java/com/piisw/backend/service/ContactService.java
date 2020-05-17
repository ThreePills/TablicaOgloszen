package com.piisw.backend.service;

import java.util.Optional;

import com.piisw.backend.entity.Contact;
import com.piisw.backend.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ContactService {

        private final ContactRepository contactRepository;

        Contact upadateContactInAdvertisement(Contact advertisementContact) {
                Optional<Contact> contactOptional = contactRepository.findAll().stream()
                                                                     .filter(contact1 -> contact1
                                                                             .equals(advertisementContact))
                                                                     .findFirst();

                return contactOptional.orElseGet(() -> contactRepository.save(advertisementContact));

        }
}
