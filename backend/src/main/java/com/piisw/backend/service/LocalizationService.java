package com.piisw.backend.service;

import com.piisw.backend.entity.Localization;
import com.piisw.backend.repository.LocalizationRepository;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LocalizationService {
  final LocalizationRepository localizationRepository;

  Localization updateLocalizationInOffer(Localization offerLocalization) {
    Optional<Localization> localizationOptional =
        localizationRepository.findAll().stream()
            .filter(localization -> localization.equals(offerLocalization))
            .findFirst();

    return localizationOptional.orElseGet(() -> localizationRepository.save(offerLocalization));
  }
}
