package com.piisw.backend.service;

import java.util.List;
import java.util.Optional;

import com.piisw.backend.entity.Advertisement;
import com.piisw.backend.entity.Contact;
import com.piisw.backend.entity.Localization;
import com.piisw.backend.repository.AdvertisementRepository;
import com.piisw.backend.repository.ContactRepository;
import com.piisw.backend.repository.LocalizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AdvertisementService {

        private final AdvertisementRepository advertisementRepository;
        private final ContactRepository contactRepository;
        private final LocalizationRepository localizationRepository;

        public List<Advertisement> findAllAdvertisement() {
                return advertisementRepository.findAll();
        }

        public List<Advertisement> findAllActiveAdvertisements() {
                return advertisementRepository.findAllByIsActive(Boolean.TRUE);
        }

        public Advertisement insertAdvertisement(Advertisement advertisement) {
                Optional<Contact> contact = contactRepository.findAll().stream()
                                                             .filter(contact1 -> contact1
                                                                     .equals(advertisement.getContact())).findFirst();
                if (contact.isPresent()) {
                        advertisement.setContact(contact.get());
                } else {
                        contactRepository.save(advertisement.getContact());

                }
                Optional<Localization> localization = localizationRepository.findAll().stream()
                                                                            .filter(localization1 -> localization1
                                                                                    .equals(advertisement
                                                                                                    .getLocalization()))
                                                                            .findFirst();
                if (localization.isPresent()) {
                        advertisement.setLocalization(localization.get());
                } else {
                        localizationRepository.save(advertisement.getLocalization());
                }
                return advertisementRepository.save(new Advertisement(advertisement));
        }

        public void removeAdvertisement(Integer advertisementId) {
                advertisementRepository.removeAdvertisement(advertisementId);

        }


}
