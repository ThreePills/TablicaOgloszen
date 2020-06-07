package com.piisw.backend.controller;

import com.piisw.backend.entity.Offer;
import com.piisw.backend.service.OfferService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/offer")
public class OfferController {

  private final OfferService offerService;

  @CrossOrigin("http://localhost:4200")
  @PostMapping
  @ResponseBody
  public ResponseEntity<Offer> addOffer(@RequestBody Offer offer) {
    return ResponseEntity.ok(offerService.insertOffer(offer));
  }

  @CrossOrigin("http://localhost:4200")
  @GetMapping(value = "/all")
  @ResponseBody
  public ResponseEntity<List<Offer>> getOffers() {
    return ResponseEntity.ok(offerService.findAllOffers());
  }

  @CrossOrigin("http://localhost:4200")
  @GetMapping(value = "/allActive")
  @ResponseBody
  public ResponseEntity<List<Offer>> getActiveOffers() {
    return ResponseEntity.ok(offerService.findAllActiveOffers());
  }

  @CrossOrigin("http://localhost:4200")
  @DeleteMapping("/{id}")
  @ResponseBody
  public void deleteOffer(@PathVariable Long id) {
    offerService.removeOffer(id);
  }
}
