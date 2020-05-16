package com.piisw.backend.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.piisw.backend.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement,Long> {

        List<Advertisement> findAll();

        Optional<Advertisement> findById(Long id);

        List<Advertisement> findAllByIsActive(Boolean isActive);

        @Modifying
        @Transactional
        @Query("update Advertisement advertisement set advertisement.isActive = false where advertisement.id = :id")
        void removeAdvertisement(@Param("id") Integer id);

}
