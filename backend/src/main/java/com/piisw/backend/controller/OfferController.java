package com.piisw.backend.controller;

import com.piisw.backend.entity.Offer;
import com.piisw.backend.service.OfferService;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/offer")
public class OfferController {

  private final OfferService offerService;

  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping
  @ResponseBody
  public ResponseEntity<Offer> addOfferWithDetailsOrUpdateIfExists(
      @Valid @RequestBody Offer offer) {
    return ResponseEntity.ok(offerService.addOfferOrUpdateIfExists(offer));
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping(value = "/all")
  @ResponseBody
  public ResponseEntity<List<Offer>> getOffers() {
    return ResponseEntity.ok(offerService.findAllOffers());
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping(value = "/list/{isActive}")
  @ResponseBody
  public ResponseEntity<List<Offer>> getOffersByIsActive(@PathVariable @NotNull Boolean isActive) {
    return ResponseEntity.ok(offerService.findOffersByIsActive(isActive));
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @DeleteMapping("/{id}")
  @ResponseBody
  public ResponseEntity<Offer> deactivateOffer(@PathVariable @NotNull Long id) {
    return ResponseEntity.ok(offerService.deactivateOffer(id));
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity<Optional<Offer>> getOfferById(@PathVariable @NotNull Long id) {
    return ResponseEntity.ok(offerService.findOfferById(id));
  }
}
