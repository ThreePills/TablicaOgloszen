package com.piisw.backend.repository;

import java.util.List;
import javax.transaction.Transactional;

import com.piisw.backend.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

        List<Offer> findAll();

        List<Offer> findAllByIsActive(Boolean isActive);

        @Modifying
        @Transactional
        @Query ("update Offer offer set offer.isActive = false where offer.id = :id")
        void removeOffer(@Param ("id") Long id);
}
