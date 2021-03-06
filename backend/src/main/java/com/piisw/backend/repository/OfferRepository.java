package com.piisw.backend.repository;

import com.piisw.backend.entity.Offer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
  List<Offer> findAllByIsActive(Boolean isActive);
}
