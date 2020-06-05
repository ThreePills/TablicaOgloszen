package com.piisw.backend.service;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import com.piisw.backend.entity.Contact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith (SpringJUnit4ClassRunner.class)
@AutoConfigureTestDatabase
public class ContactServiceTests {

        @Autowired
        ContactService contactService;

        @Test
        public void testUpdateContactShouldReturnExistingContact() {
                Contact contact = Contact.builder().email("test2@mail.com").name("Test2").phoneNumber(1234).build();

                Contact contactUpdated = contactService.upadateContactInOffer(contact);

                assertThat(contact.getName(), equalTo(contactUpdated.getName()));
                assertThat(contact.getEmail(), equalTo(contactUpdated.getEmail()));
                assertThat(contact.getPhoneNumber(), equalTo(contactUpdated.getPhoneNumber()));
                assertThat(2L, equalTo(contactUpdated.getId()));
        }

        @Test
        public void testUpdateContactShouldReturnNewContact() {
                Contact contact = Contact.builder().email("test4@mail.com").name("Test4").phoneNumber(4321).build();

                Contact contactUpdated = contactService.upadateContactInOffer(contact);

                assertThat(contact.getName(), equalTo(contactUpdated.getName()));
                assertThat(contact.getEmail(), equalTo(contactUpdated.getEmail()));
                assertThat(contact.getPhoneNumber(), equalTo(contactUpdated.getPhoneNumber()));
                assertThat(4L, equalTo(contactUpdated.getId()));
        }

        @Test
        public void testFindByIdContactSuccessful() {
                Optional<Contact> contactOptional = contactService.findById(1L);

                assertThat(contactOptional.get(), is(notNullValue()));

        }

}
