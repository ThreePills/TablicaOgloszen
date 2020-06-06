package com.piisw.backend.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.piisw.backend.entity.Contact;
import com.piisw.backend.entity.Localization;
import com.piisw.backend.entity.Offer;
import com.piisw.backend.repository.OfferRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith (MockitoJUnitRunner.class)
public class OfferServiceTests {


        @Spy
        @Autowired
        private OfferRepository offerRepository;
        @Mock
        private ContactService contactService;
        @Mock
        private LocalizationService localizationService;
        @InjectMocks
        private OfferService offerService;

        @Test
        public void testInsertOffer() {
                Offer offer = Offer.builder().id(1L).title("Title1").content("Content1").isActive(Boolean.TRUE).contact(
                        Contact.builder().id(1L).name("contact 1").email("contact1@mail").phoneNumber(4566).build())
                                   .localization(Localization.builder().id(1L).country("country 1").region("region 1")
                                                             .zipCode("44-333").localizationName("Local name").build())
                                   .build();
                when(offerService.addOfferOrUpdateIfExists(offer)).thenReturn(offer);

                Offer offerOptional = offerService.addOfferOrUpdateIfExists(offer);

                assertThat(1L, equalTo(offerOptional.getId()));
        }

        @Test
        public void testFindAllActiveOffers() {
                Localization localization = Localization.builder()
                                                        .id(1L)
                                                        .country("country 1")
                                                        .region("region 1")
                                                        .zipCode("44-333")
                                                        .localizationName("Local name")
                                                        .build();
                Contact contact = Contact.builder()
                                         .id(1L)
                                         .name("contact 1")
                                         .email("contact1@mail")
                                         .phoneNumber(4566)
                                         .build();
                Offer offer = Offer.builder()
                                   .id(1L)
                                   .title("Title1")
                                   .content("Content1")
                                   .isActive(Boolean.TRUE)
                                   .contact(contact)
                                   .localization(localization)
                                   .build();
                Offer offer2 = Offer.builder()
                                    .id(2L)
                                    .title("Title2")
                                    .content("Content2")
                                    .isActive(Boolean.TRUE)
                                    .contact(contact)
                                    .localization(localization)
                                    .build();
                when(offerService.findOffersByIsActive(Boolean.TRUE)).thenReturn(Arrays.asList(offer, offer2));

                List<Offer> allActiveOffers = offerService.findOffersByIsActive(Boolean.TRUE);


                assertThat(2, equalTo(allActiveOffers.size()));
        }

        @Test
        public void testFindAllOffers() {
                Contact contact = Contact.builder()
                                         .id(1L)
                                         .name("contact 1")
                                         .email("contact1@mail")
                                         .phoneNumber(4566)
                                         .build();
                Localization localization = Localization.builder()
                                                        .id(1L)
                                                        .country("country 1")
                                                        .region("region 1")
                                                        .zipCode("44-333")
                                                        .localizationName("Local name")
                                                        .build();
                Offer offer = Offer.builder()
                                   .id(1L)
                                   .title("Title1")
                                   .content("Content1")
                                   .isActive(Boolean.TRUE)
                                   .contact(contact)
                                   .localization(localization)
                                   .build();
                when(offerService.findAllOffers()).thenReturn(Collections.singletonList(offer));

                List<Offer> allActiveOffers = offerService.findAllOffers();


                assertThat(1, equalTo(allActiveOffers.size()));
        }


}
