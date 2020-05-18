package com.piisw.backend.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
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
        OfferRepository offerRepository;
        @Mock
        ContactService contactService;
        @Mock
        LocalizationService localizationService;

        @InjectMocks
        OfferService offerService;

        @Test
        public void testInsertOffer() {
                Contact contact = new Contact(1L, "contact 1", "contact1@mail", 4566);
                Localization localization = new Localization(1L, "country 1", "region 1", "44-333", "Local name");
                Offer offer = new Offer(1L,"Title1","Content1",Boolean.TRUE,contact,localization);
                when(offerService.insertOffer(offer)).thenReturn(offer);

                Offer offerOptional = offerService.insertOffer(offer);


                assertThat(1L, equalTo(offerOptional.getId()));
        }

        @Test
        public void testFindAllActiveOffers() {
                Contact contact = new Contact(1L, "contact 1", "contact1@mail", 4566);
                Localization localization = new Localization(1L, "country 1", "region 1", "44-333", "Local name");
                Offer offer = new Offer(1L,"Title1","Content1",Boolean.TRUE,contact,localization);
                Offer offer2 = new Offer(2L,"Title2","Content2",Boolean.TRUE,contact,localization);
                when(offerService.findAllActiveOffers()).thenReturn(Arrays.asList(offer,offer2));

                List<Offer> allActiveOffers = offerService.findAllActiveOffers();


                assertThat(2, equalTo(allActiveOffers.size()));
        }
        @Test
        public void testFindAllOffers() {
                Contact contact = new Contact(1L, "contact 1", "contact1@mail", 4566);
                Localization localization = new Localization(1L, "country 1", "region 1", "44-333", "Local name");
                Offer offer = new Offer(1L,"Title1","Content1",Boolean.TRUE,contact,localization);
                when(offerService.findAllOffers()).thenReturn(Arrays.asList(offer));

                List<Offer> allActiveOffers = offerService.findAllOffers();


                assertThat(1, equalTo(allActiveOffers.size()));
        }
}
