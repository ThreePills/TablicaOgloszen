package com.piisw.backend.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.piisw.backend.entity.Contact;
import com.piisw.backend.entity.Localization;
import com.piisw.backend.entity.Offer;
import com.piisw.backend.service.OfferService;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
public class OfferControllersTests {
  private OfferService offerService;
  private OfferController offerController;
  private MockMvc mockMvc;
  private ObjectMapper mapper;

  @Before
  public void setUp() {
    mapper = new ObjectMapper();
    offerService = Mockito.mock(OfferService.class);
    offerController = new OfferController(offerService);
    mockMvc = MockMvcBuilders.standaloneSetup(offerController).build();
  }

  @After
  public void tearDown() {
    mockMvc = null;
    offerController = null;
    offerService = null;
  }

  @Test
  public void testGetAllWithStatusOk() throws Exception {

    List<Offer> offerList = new ArrayList<Offer>();

    Contact contact =
        Contact.builder().id(1L).name("contact 1").email("contact1@mail").phoneNumber(4566).build();
    Localization localization =
        Localization.builder()
            .id(1L)
            .country("country 1")
            .region("region 1")
            .zipCode("44-333")
            .localizationName("Local name")
            .build();
    Offer activeOffer =
        Offer.builder()
            .id(1L)
            .localization(localization)
            .isActive(Boolean.TRUE)
            .title("Offer title 1")
            .content("Offer 1 content")
            .contact(contact)
            .build();

    Offer inactiveOffer =
        Offer.builder()
            .id(2L)
            .contact(contact)
            .content("Offer 2 content")
            .title("Offer 2 title")
            .isActive(Boolean.FALSE)
            .localization(localization)
            .build();
    offerList.add(activeOffer);
    offerList.add(inactiveOffer);

    given(this.offerService.findAllOffers()).willReturn(offerList);

    this.mockMvc
        .perform(get("/offer/all").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(2))
        .andExpect(jsonPath("$.[1].id").value(2))
        .andExpect(jsonPath("$.[1].title").value("Offer 2 title"))
        .andExpect(jsonPath("$.[1].content").value("Offer 2 content"))
        .andExpect(jsonPath("$.[1].active").value(Boolean.FALSE))
        .andExpect(jsonPath("$.[1].contact.id").value(1))
        .andExpect(jsonPath("$.[1].localization.id").value(1));
  }

  @Test
  public void testGetAllWithStatusClientError() throws Exception {
    mockMvc.perform(get("/offer/al")).andExpect(status().is4xxClientError());
  }

  @Test
  public void testGetAllWithStatusMethodNotAllowed() throws Exception {
    mockMvc.perform(post("/offer/all")).andExpect(status().isMethodNotAllowed());
  }

  @Test
  public void testGetAllActiveWithStatusOk() throws Exception {
    List<Offer> offerList = new ArrayList<Offer>();

    Contact contact =
        Contact.builder()
            .id(1L)
            .name("contact 1")
            .email("contact1@mail.com")
            .phoneNumber(4566)
            .build();
    Localization localization =
        Localization.builder()
            .id(1L)
            .country("country 1")
            .region("region 1")
            .zipCode("44-333")
            .localizationName("Local name")
            .build();
    Offer activeOffer =
        Offer.builder()
            .id(1L)
            .localization(localization)
            .isActive(Boolean.TRUE)
            .title("Offer title 1")
            .content("Offer 1 content")
            .contact(contact)
            .build();

    Offer inactiveOffer =
        Offer.builder()
            .id(2L)
            .contact(contact)
            .content("Offer 2 content")
            .title("Offer 2 title")
            .isActive(Boolean.FALSE)
            .localization(localization)
            .build();
    offerList.add(activeOffer);
    offerList.add(inactiveOffer);

    offerList.remove(1);
    given(this.offerService.findOffersByIsActive(Boolean.TRUE)).willReturn(offerList);
    mockMvc
        .perform(get("/offer/list/true"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(1))
        .andExpect(jsonPath("$.[0].id").value(1))
        .andExpect(jsonPath("$.[0].title").value("Offer title 1"))
        .andExpect(jsonPath("$.[0].content").value("Offer 1 content"))
        .andExpect(jsonPath("$.[0].active").value(Boolean.TRUE))
        .andExpect(jsonPath("$.[0].contact.id").value(1))
        .andExpect(jsonPath("$.[0].localization.id").value(1));
  }

  @Test
  public void testGetAllActiveWithStatusClientError() throws Exception {
    final ResultActions resultActions = mockMvc.perform(post("/offer/allActive"));
    resultActions.andExpect(status().is4xxClientError());
  }

  @Test
  public void testPostOfferWithStatusOk() throws Exception {

    Contact contact =
        Contact.builder().id(1L).name("contact 1").email("contact1@mail").phoneNumber(4566).build();
    Localization localization =
        Localization.builder()
            .id(1L)
            .country("country 1")
            .region("region 1")
            .zipCode("44-333")
            .localizationName("Local name")
            .build();
    Offer offer =
        Offer.builder()
            .id(1L)
            .localization(localization)
            .isActive(Boolean.TRUE)
            .title("Offer title 1")
            .content("Offer 1 content")
            .contact(contact)
            .build();

    this.mockMvc
        .perform(
            post("/offer")
                .content(mapper.writeValueAsString(offer))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk());
  }

  @Test
  public void testPostOfferWithStatusClientError() throws Exception {
    final ResultActions resultActions = mockMvc.perform(post("/offer"));

    resultActions.andExpect(status().is4xxClientError());
  }

  @Test
  public void testPostOfferWithStatusMethodNotAllowed() throws Exception {
    final ResultActions resultActions = mockMvc.perform(get("/offer"));

    resultActions.andExpect(status().isMethodNotAllowed());
  }

  @Test
  public void testPutOfferWithStatusOk() throws Exception {

    Contact contact =
        Contact.builder()
            .id(1L)
            .name("Contact 1")
            .email("contact1@mail.com")
            .phoneNumber(4566)
            .build();
    Localization localization =
        Localization.builder()
            .id(1L)
            .country("Country 1")
            .region("Region 1")
            .zipCode("44-333")
            .localizationName("Local name")
            .build();
    Offer offer =
        Offer.builder()
            .id(1L)
            .localization(localization)
            .isActive(Boolean.TRUE)
            .title("Offer title 1")
            .content("Offer 1 content")
            .contact(contact)
            .build();

    offer.setTitle("New title");
    given(this.offerService.addOfferOrUpdateIfExists(offer)).willReturn(offer);

    this.mockMvc
        .perform(
            post("/offer")
                .content(mapper.writeValueAsString(offer))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.title").value("New title"));
  }

  @Test
  public void testPutOfferWithStatusMethodNotAllowed() throws Exception {
    final ResultActions resultActions = mockMvc.perform(get("/offer"));

    resultActions.andExpect(status().isMethodNotAllowed());
  }

  @Test
  public void testDeleteOfferWithStatusOk() throws Exception {
    Contact contact =
        Contact.builder().id(1L).name("contact 1").email("contact1@mail").phoneNumber(4566).build();
    Localization localization =
        Localization.builder()
            .id(1L)
            .country("country 1")
            .region("region 1")
            .zipCode("44-333")
            .localizationName("Local name")
            .build();
    Offer offer =
        Offer.builder()
            .id(1L)
            .localization(localization)
            .isActive(Boolean.TRUE)
            .title("Offer title 1")
            .content("Offer 1 content")
            .contact(contact)
            .build();

    this.mockMvc.perform(delete("/offer/" + offer.getId())).andExpect(status().isOk());
  }

  @Test
  public void testFindOfferByIdWithStatusOk() throws Exception {
    Contact contact =
        Contact.builder().id(1L).name("contact 1").email("contact1@mail").phoneNumber(4566).build();
    Localization localization =
        Localization.builder()
            .id(1L)
            .country("country 1")
            .region("region 1")
            .zipCode("44-333")
            .localizationName("Local name")
            .build();
    Offer offer =
        Offer.builder()
            .id(1L)
            .localization(localization)
            .isActive(Boolean.TRUE)
            .title("Offer title 1")
            .content("Offer 1 content")
            .contact(contact)
            .build();

    this.mockMvc.perform(get("/offer/" + offer.getId())).andExpect(status().isOk());
  }
}
