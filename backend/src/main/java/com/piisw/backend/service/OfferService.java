package com.piisw.backend.service;

import java.util.List;
import javax.transaction.Transactional;

import com.piisw.backend.entity.Offer;
import com.piisw.backend.repository.OfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Transactional
public class OfferService {

        private final OfferRepository offerRepository;
        private final ContactService contactService;
        private final LocalizationService localizationService;

        public List<Offer> findAllOffers() {
                return offerRepository.findAll();
        }

        public List<Offer> findOffersByIsActive(Boolean isActive) {
                return offerRepository.findAllByIsActive(isActive);
        }

        public Offer addOfferOrUpdateIfExists(Offer offer) {
                offer.setContact(contactService.saveNewContactIfDoesntExists(offer.getContact()));
                offer.setLocalization(
                        localizationService.updateLocalizationInOffer(offer.getLocalization()));

                if (offer.getId() != null && offerRepository.findById(offer.getId()).isPresent()) {
                        return updateOfferDetails(offerRepository.getOne(offer.getId()), offer);
                } else {
                        return offerRepository.save(offer);
                }

        }

        private Offer updateOfferDetails(Offer offerCopy,
                                         Offer offer) {

                offerCopy.setTitle(offer.getTitle());
                offerCopy.setLocalization(offer.getLocalization());
                offerCopy.setContent(offer.getContent());
                offerCopy.setLocalization(offer.getLocalization());
                offerCopy.setContact(offer.getContact());
                return offerRepository.save(offerCopy);
        }

        public void deactivateOffer(Long offerId) {
                offerRepository.deactivateOffer(offerId);

        }
        
}
