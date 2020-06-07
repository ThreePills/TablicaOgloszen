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
  private List<Offer> offerList;
  private ObjectMapper mapper;

  @Before
  public void setUp() {
    mapper = new ObjectMapper();
    offerService = Mockito.mock(OfferService.class);
    offerController = new OfferController(offerService);
    mockMvc = MockMvcBuilders.standaloneSetup(offerController).build();
    offerList = new ArrayList<Offer>();
    Offer activeOffer = new Offer();
    Contact contact = new Contact(1L, "contact 1", "contact1@mail", 4566);
    Localization localization =
        new Localization(1L, "country 1", "region 1", "44-333", "Local name");
    activeOffer.setId(1L);
    activeOffer.setLocalization(localization);
    activeOffer.setActive(Boolean.TRUE);
    activeOffer.setTitle("Offer title 1");
    activeOffer.setContent("Offer 1 content");
    activeOffer.setContact(contact);
    offerList.add(activeOffer);
    Offer inactiveOffer = new Offer();
    inactiveOffer.setId(2L);
    inactiveOffer.setContact(contact);
    inactiveOffer.setContent("Offer 2 content");
    inactiveOffer.setTitle("Offer 2 title");
    inactiveOffer.setActive(Boolean.FALSE);
    inactiveOffer.setLocalization(localization);
    offerList.add(inactiveOffer);
  }

  @After
  public void tearDown() {
    mockMvc = null;
    offerController = null;
    offerService = null;
  }

  @Test
  public void testGetAllWithStatusOk() throws Exception {
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
    offerList.remove(1);
    given(this.offerService.findAllActiveOffers()).willReturn(offerList);
    mockMvc
        .perform(get("/offer/allActive"))
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
  public void testGetAllActiveWithStatusMethodNotAllowed() throws Exception {
    final ResultActions resultActions = mockMvc.perform(get("/offer/alActiv"));
    resultActions.andExpect(status().isMethodNotAllowed());
  }

  @Test
  public void testPostOfferWithStatusOk() throws Exception {
    Offer offer = offerList.get(0);

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

    Offer offer = offerList.get(0);
    offer.setTitle("new title");
    given(this.offerService.insertOffer(offer)).willReturn(offerList.get(0));

    this.mockMvc
        .perform(
            post("/offer")
                .content(mapper.writeValueAsString(offer))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.title").value("new title"));
  }

  @Test
  public void testPutOfferWithStatusMethodNotAllowed() throws Exception {
    final ResultActions resultActions = mockMvc.perform(get("/offer"));

    resultActions.andExpect(status().isMethodNotAllowed());
  }

  @Test
  public void testDeleteOfferWithStatusOk() throws Exception {

    this.mockMvc.perform(delete("/offer/" + offerList.get(0).getId())).andExpect(status().isOk());
  }

  @Test
  public void testDeleteOfferWithStatusMethodNotAllowed() throws Exception {
    final ResultActions resultActions = mockMvc.perform(get("/offer/" + offerList.get(0).getId()));

    resultActions.andExpect(status().isMethodNotAllowed());
  }
}
