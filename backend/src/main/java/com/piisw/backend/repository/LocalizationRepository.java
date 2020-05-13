package com.piisw.backend.repository;

import java.util.Optional;

import com.piisw.backend.entity.Localization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizationRepository extends JpaRepository<Localization,Integer> {
        Optional<Localization> findById(Integer id);
}
