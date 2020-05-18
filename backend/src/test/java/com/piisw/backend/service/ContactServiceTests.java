package com.piisw.backend.service;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import com.piisw.backend.entity.Contact;
import com.piisw.backend.repository.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@RunWith (MockitoJUnitRunner.class)
public class ContactServiceTests {

        @Mock
        ContactRepository contactRepository;

        @InjectMocks
        ContactService contactService;

        @Test
        public void testUpdateContact() {
                Contact contact = new Contact(1L, "Test1", "test1@mail.com", 1234);
                when(contactService.upadateContactInOffer(contact)).thenReturn(contact);

                Contact contactUpdated = contactService.upadateContactInOffer(contact);

                assertThat("Test1", equalTo(contactUpdated.getName()));
                assertThat("test1@mail.com", equalTo(contactUpdated.getEmail()));
                assertThat(1234, equalTo(contactUpdated.getPhoneNumber()));
                assertThat(1L, equalTo(contactUpdated.getId()));
        }
}
