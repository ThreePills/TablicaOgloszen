package com.piisw.backend.service;

import javax.transaction.Transactional;

import com.piisw.backend.entity.Localization;
import com.piisw.backend.repository.LocalizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Transactional
public class LocalizationService {
        private final LocalizationRepository localizationRepository;

        Localization updateLocalizationInOffer(Localization offerLocalization) {
                return localizationRepository.findByHashValueEquals(offerLocalization.hashCode())
                                             .orElseGet(() -> localizationRepository.save(offerLocalization));

        }
}
