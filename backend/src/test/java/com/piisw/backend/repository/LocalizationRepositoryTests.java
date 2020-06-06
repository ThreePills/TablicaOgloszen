package com.piisw.backend.repository;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

import com.piisw.backend.entity.Localization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith (SpringRunner.class)
@DataJpaTest
public class LocalizationRepositoryTests {

        @Autowired
        private LocalizationRepository localizationRepository;

        @Test
        public void testFindAllLocalizations() {
                List<Localization> localizationList = localizationRepository.findAll();

                assertEquals(3, localizationList.size());
        }

        @Test
        public void testFindByIdLocalization() {
                Optional<Localization> localization = localizationRepository.findById(1L);

                assertEquals(Boolean.TRUE, localization.isPresent());

                assertEquals("country1", localization.get().getCountry());
        }

        @Test
        public void testDetailsOFLocalization() {
                Localization localization = localizationRepository.getOne(3L);

                assertThat(3L, equalTo(localization.getId()));
                assertThat("country3", equalTo(localization.getCountry()));
                assertThat("localization3", equalTo(localization.getLocalizationName()));
                assertThat("58-120", equalTo(localization.getZipCode()));
        }
}
