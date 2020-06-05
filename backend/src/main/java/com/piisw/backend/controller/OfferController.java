package com.piisw.backend.controller;

import java.util.List;

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
        public ResponseEntity<Offer> addOffer(@RequestBody Offer offer) {
                return ResponseEntity.ok(offerService.insertOffer(offer));
        }

        @GetMapping (value = "/all")
        @ResponseBody
        public ResponseEntity<List<Offer>> getOffers() {
                return ResponseEntity.ok(offerService.findAllOffers());
        }

        @GetMapping (value = "/{isActive}")
        @ResponseBody
        public ResponseEntity<List<Offer>> getOffersByIsActive(@PathVariable Boolean isActive) {
                return ResponseEntity.ok(offerService.findOffersByIsActive(isActive));
        }

        @DeleteMapping ("/{id}")
        @ResponseBody
        public void deleteOffer(@PathVariable Long id) {
                offerService.removeOffer(id);
        }
}
