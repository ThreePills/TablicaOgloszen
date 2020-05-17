package com.piisw.backend.service;

import java.util.List;
import java.util.Optional;

import com.piisw.backend.entity.Advertisement;
import com.piisw.backend.repository.AdvertisementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AdvertisementService {

        private final AdvertisementRepository advertisementRepository;
        private final ContactService contactService;
        private final LocalizationService localizationService;

        public List<Advertisement> findAllAdvertisement() {
                return advertisementRepository.findAll();
        }

        public List<Advertisement> findAllActiveAdvertisements() {
                return advertisementRepository.findAllByIsActive(Boolean.TRUE);
        }

        public Advertisement insertAdvertisement(Advertisement advertisement) {
                Optional<Advertisement> advertisementOptional = Optional.empty();

                advertisement.setContact(contactService.upadateContactInAdvertisement(advertisement.getContact()));
                advertisement.setLocalization(
                        localizationService.updateLocalizationInAdvertisement(advertisement.getLocalization()));

                if (advertisement.getId() != null) {
                        advertisementOptional = advertisementRepository
                                .findById(advertisement.getId());
                }

                if (advertisementOptional.isPresent()) {
                        return updateAdvertisementDetails(advertisementOptional.get(), advertisement);

                } else {
                        return advertisementRepository.save(advertisement);
                }
        }

        private Advertisement updateAdvertisementDetails(Advertisement advertisementCopy,
                                                         Advertisement advertisement) {

                advertisementCopy.setTitle(advertisement.getTitle());
                advertisementCopy.setLocalization(advertisement.getLocalization());
                advertisementCopy.setContent(advertisement.getContent());
                advertisementCopy.setLocalization(advertisement.getLocalization());
                advertisementCopy.setContact(advertisement.getContact());
                return advertisementRepository.save(advertisementCopy);
        }

        public void removeAdvertisement(Integer advertisementId) {
                advertisementRepository.removeAdvertisement(advertisementId);

        }


}
