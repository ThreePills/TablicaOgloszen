package com.piisw.backend.service;

import java.util.Optional;

import com.piisw.backend.entity.Localization;
import com.piisw.backend.repository.LocalizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LocalizationService {
        final LocalizationRepository localizationRepository;

        Localization updateLocalizationInAdvertisement(Localization advertisementLocalization) {
                Optional<Localization> localizationOptional = localizationRepository.findAll().stream()
                                                                                    .filter(localization1 -> localization1
                                                                                            .equals(advertisementLocalization))
                                                                                    .findFirst();

                return localizationOptional.orElseGet(() -> localizationRepository.save(advertisementLocalization));


        }
}
