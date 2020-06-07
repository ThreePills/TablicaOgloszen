package com.piisw.backend.service;

import com.piisw.backend.entity.Localization;
import com.piisw.backend.repository.LocalizationRepository;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Transactional
public class LocalizationService {
  private final LocalizationRepository localizationRepository;

  Localization updateLocalizationInOffer(Localization offerLocalization) {
    return localizationRepository
        .findByHashValueEquals(offerLocalization.hashCode())
        .orElseGet(() -> localizationRepository.save(offerLocalization));
  }
}
