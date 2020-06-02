package com.piisw.backend.service;

import com.piisw.backend.entity.Offer;
import com.piisw.backend.repository.OfferRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OfferService {

  private final OfferRepository offerRepository;
  private final ContactService contactService;
  private final LocalizationService localizationService;

  public List<Offer> findAllOffers() {
    return offerRepository.findAll();
  }

  public List<Offer> findAllActiveOffers() {
    return offerRepository.findAllByIsActive(Boolean.TRUE);
  }

  public Offer insertOffer(Offer offer) {
    Optional<Offer> offerOptional = Optional.empty();

    offer.setContact(contactService.upadateContactInOffer(offer.getContact()));
    offer.setLocalization(localizationService.updateLocalizationInOffer(offer.getLocalization()));

    if (offer.getId() != null) {
      offerOptional = offerRepository.findById(offer.getId());
    }

    if (offerOptional.isPresent()) {
      return updateOfferDetails(offerOptional.get(), offer);

    } else {
      return offerRepository.save(offer);
    }
  }

  private Offer updateOfferDetails(Offer offerCopy, Offer offer) {

    offerCopy.setTitle(offer.getTitle());
    offerCopy.setLocalization(offer.getLocalization());
    offerCopy.setContent(offer.getContent());
    offerCopy.setLocalization(offer.getLocalization());
    offerCopy.setContact(offer.getContact());
    return offerRepository.save(offerCopy);
  }

  public void removeOffer(Long offerId) {
    offerRepository.removeOffer(offerId);
  }
}
