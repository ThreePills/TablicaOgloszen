package com.piisw.backend.service;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import com.piisw.backend.entity.Localization;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore
@SpringBootTest
@RunWith (SpringJUnit4ClassRunner.class)
@AutoConfigureTestDatabase
public class LocalizationServiceTests {

        @Autowired
        private LocalizationService localizationService;

        @Test
        public void testUpdateLocalization() {
                Localization localization = Localization.builder()
                                                        .country("country test")
                                                        .region("region test")
                                                        .localizationName("localization")
                                                        .zipCode("58-333")
                                                        .build();

                Localization localizationUpdated = localizationService.updateLocalizationInOffer(localization);

                assertThat("country1", equalTo(localizationUpdated.getCountry()));
                assertThat("region1", equalTo(localizationUpdated.getRegion()));
                assertThat("58-120", equalTo(localizationUpdated.getZipCode()));
                assertThat("localization1", equalTo(localizationUpdated.getLocalizationName()));
        }

}
