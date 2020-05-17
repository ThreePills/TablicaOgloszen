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

        Localization updateLocalizationInOffer(Localization offerLocalization) {
                Optional<Localization> localizationOptional = localizationRepository.findAll().stream()
                                                                                    .filter(localization -> localization
                                                                                            .equals(offerLocalization))
                                                                                    .findFirst();

                return localizationOptional.orElseGet(() -> localizationRepository.save(offerLocalization));
        }
}
