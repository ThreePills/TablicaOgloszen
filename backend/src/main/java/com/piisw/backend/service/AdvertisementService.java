package com.piisw.backend.service;

import java.util.List;
import java.util.Optional;

import com.piisw.backend.entity.Advertisement;
import com.piisw.backend.repository.AdvertisementRepository;
import com.piisw.backend.repository.ContactRepository;
import com.piisw.backend.repository.LocalizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementService {

        @Autowired
        private AdvertisementRepository advertisementRepository;

        @Autowired
        private ContactRepository contactRepository;

        @Autowired
        private LocalizationRepository localizationRepository;

        public AdvertisementService(@Autowired AdvertisementRepository advertisementRepository) {
                this.advertisementRepository = advertisementRepository;
        }


        public List<Advertisement> findAllAdvertisement(){
                return advertisementRepository.findAll();
        }
        public List<Advertisement> findAllActiveAdvertisements(){
                return advertisementRepository.findAllByIsActive('Y');
        }
        public Advertisement insertAdvertisement(Advertisement advertisement){
                contactRepository.save(advertisement.getContact());
                localizationRepository.save(advertisement.getLocalization());
                return advertisementRepository.save(new Advertisement(advertisement));
        }
        public void removeAdvertisement(Integer advertisementId){
                advertisementRepository.removeAdvertisement(advertisementId);

        }

}
