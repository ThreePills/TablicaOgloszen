package com.piisw.backend.repository;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import com.piisw.backend.entity.Contact;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContactRepositoryTests {

  @Autowired private ContactRepository contactRepository;

  @Test
  public void testfindAllContacts() {
    List<Contact> contactList = contactRepository.findAll();

    assertEquals(3, contactList.size());
  }

  @Test
  public void testFindByIdContact() {
    Optional<Contact> contact = contactRepository.findById(1L);

    assertEquals(Boolean.TRUE, contact.isPresent());

    assertEquals("Test1", contact.get().getName());
  }

  @Test
  public void testDetailsOFContact() {
    Contact contact = contactRepository.findById(3L).get();

    assertThat(3L, equalTo(contact.getId()));
    assertThat("Test3", equalTo(contact.getName()));
    assertThat("test3@mail.com", equalTo(contact.getEmail()));
    assertThat(1234, equalTo(contact.getPhoneNumber()));
  }
}
