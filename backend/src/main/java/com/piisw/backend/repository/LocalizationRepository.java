package com.piisw.backend.repository;

import com.piisw.backend.entity.Localization;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizationRepository extends JpaRepository<Localization, Long> {
  Optional<Localization> findByHashValueEquals(int hashValue);
}
