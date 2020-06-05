package com.piisw.backend.service;

import com.piisw.backend.entity.Localization;
import com.piisw.backend.repository.LocalizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LocalizationService {
        private final LocalizationRepository localizationRepository;

        Localization updateLocalizationInOffer(Localization offerLocalization) {
                return localizationRepository.findAll().stream()
                                             .filter(localization -> localization.equals(offerLocalization)).findFirst()
                                             .orElseGet(() -> localizationRepository.save(offerLocalization));
        }
}
