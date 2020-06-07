package com.piisw.backend.service;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import com.piisw.backend.entity.Localization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest
@RunWith (SpringJUnit4ClassRunner.class)
@AutoConfigureTestDatabase
@DirtiesContext (classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
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

                assertThat("country test", equalTo(localizationUpdated.getCountry()));
                assertThat("region test", equalTo(localizationUpdated.getRegion()));
                assertThat("58-333", equalTo(localizationUpdated.getZipCode()));
                assertThat("localization", equalTo(localizationUpdated.getLocalizationName()));
                assertThat(10L, equalTo(localizationUpdated.getId()));
        }

}
