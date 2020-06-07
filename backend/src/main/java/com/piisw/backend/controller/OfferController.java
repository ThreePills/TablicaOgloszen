package com.piisw.backend.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.piisw.backend.entity.Offer;
import com.piisw.backend.service.OfferService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping (value = "/offer")
public class OfferController {

        private final OfferService offerService;

        @PostMapping
        @ResponseBody
        public ResponseEntity<Offer> addOfferWithDetailsOrUpdateIfExists(@Valid @RequestBody Offer offer) {
                return ResponseEntity.ok(offerService.addOfferOrUpdateIfExists(offer));
        }

        @GetMapping (value = "/all")
        @ResponseBody
        public ResponseEntity<List<Offer>> getOffers() {
                return ResponseEntity.ok(offerService.findAllOffers());
        }

        @GetMapping (value = "/list/{isActive}")
        @ResponseBody
        public ResponseEntity<List<Offer>> getOffersByIsActive(@PathVariable @NotNull Boolean isActive) {
                return ResponseEntity.ok(offerService.findOffersByIsActive(isActive));
        }

        @DeleteMapping ("/{id}")
        @ResponseBody
        public ResponseEntity<Offer> deactivateOffer(@PathVariable @NotNull Long id) {
                return ResponseEntity.ok(offerService.deactivateOffer(id));
        }

        @GetMapping ("/{id}")
        @ResponseBody
        public ResponseEntity<Optional<Offer>> geetOfferById(@PathVariable @NotNull Long id) {
                return ResponseEntity.ok(offerService.findOfferById(id));
        }

}
