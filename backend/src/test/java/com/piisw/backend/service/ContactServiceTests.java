package com.piisw.backend.service;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import com.piisw.backend.entity.Contact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ContactServiceTests {

  @Autowired private ContactService contactService;

  @Test
  public void testUpdateContactShouldReturnExistingContact() {
    Contact contact =
        Contact.builder().email("test2@mail.com").name("Test2").phoneNumber(1234).build();

    Contact contactUpdated = contactService.saveNewContactIfDoesntExists(contact);

    assertThat(contact.getName(), equalTo(contactUpdated.getName()));
    assertThat(contact.getEmail(), equalTo(contactUpdated.getEmail()));
    assertThat(contact.getPhoneNumber(), equalTo(contactUpdated.getPhoneNumber()));
    assertThat(99598723, equalTo(contactUpdated.hashCode()));
    assertThat(2L, equalTo(contactUpdated.getId()));
  }

  @Test
  public void testUpdateContactShouldReturnNewContact() {
    Contact contact =
        Contact.builder().email("test4@mail.com").name("Test4").phoneNumber(4321).build();

    Contact contactUpdated = contactService.saveNewContactIfDoesntExists(contact);

    assertThat(contact.getName(), equalTo(contactUpdated.getName()));
    assertThat(contact.getEmail(), equalTo(contactUpdated.getEmail()));
    assertThat(contact.getPhoneNumber(), equalTo(contactUpdated.getPhoneNumber()));
    assertThat(10L, equalTo(contactUpdated.getId()));
  }
}
