package com.piisw.backend.repository;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import com.piisw.backend.entity.Contact;
import com.piisw.backend.entity.Localization;
import com.piisw.backend.entity.Offer;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OfferRepositoryTests {

  @Autowired ContactRepository contactRepository;
  @Autowired LocalizationRepository localizationRepository;
  @Autowired OfferRepository offerRepository;

  @Test
  public void testFindOffersByIsActive() {
    List<Offer> activeOfferList = offerRepository.findAllByIsActive(Boolean.TRUE);
    List<Offer> nonActiveOfferList = offerRepository.findAllByIsActive(Boolean.FALSE);
    List<Offer> AllOfferList = offerRepository.findAll();

    assertEquals(5, activeOfferList.size());
    assertEquals(2, nonActiveOfferList.size());
    assertEquals(7, AllOfferList.size());
  }

  @Test
  public void testFindByIdOffer() {
    Optional<Offer> offer = offerRepository.findById(5L);
    Localization offerLocalization = localizationRepository.getOne(2L);
    Contact offerContact = contactRepository.getOne(1L);

    assertEquals(Boolean.TRUE, offer.isPresent());

    assertEquals(Boolean.TRUE, offer.get().isActive());
    assertThat(offerContact, samePropertyValuesAs(offer.get().getContact()));
    assertThat(offerLocalization, samePropertyValuesAs(offer.get().getLocalization()));
    assertEquals("Sprzedam auto za darmo", offer.get().getTitle());
  }
}
