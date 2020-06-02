package com.piisw.backend.service;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import com.piisw.backend.entity.Localization;
import com.piisw.backend.repository.LocalizationRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LocalizationServiceTests {

  @Mock LocalizationRepository localizationRepository;

  @InjectMocks LocalizationService localizationService;

  @Test
  public void testUpdateLocalization() {
    Localization localization =
        new Localization(1L, "country1", "region1", "58-120", "localization1");
    when(localizationService.updateLocalizationInOffer(localization)).thenReturn(localization);

    Localization localizationUpdated = localizationService.updateLocalizationInOffer(localization);

    assertThat("country1", equalTo(localizationUpdated.getCountry()));
    assertThat("region1", equalTo(localizationUpdated.getRegion()));
    assertThat("58-120", equalTo(localizationUpdated.getZipCode()));
    assertThat("localization1", equalTo(localizationUpdated.getLocalizationName()));
  }
}
