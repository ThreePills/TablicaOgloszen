package com.piisw.backend.repository;

import java.util.List;

import com.piisw.backend.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
  List<Offer> findAllByIsActive(Boolean isActive);
}
