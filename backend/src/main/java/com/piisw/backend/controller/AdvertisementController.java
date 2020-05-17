package com.piisw.backend.controller;

import java.util.List;

import com.piisw.backend.entity.Advertisement;
import com.piisw.backend.service.AdvertisementService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping (value = "/advertisement")
public class AdvertisementController {

        private final AdvertisementService advertisementService;

        @PostMapping
        @ResponseBody
        public ResponseEntity<Advertisement> addAdvertisement(@RequestBody Advertisement advertisement) {
                return ResponseEntity.ok(advertisementService.insertAdvertisement(advertisement));
        }

        @GetMapping (value = "/all")
        @ResponseBody
        public ResponseEntity<List<Advertisement>> getAdvertisements() {
                return ResponseEntity.ok(advertisementService.findAllAdvertisement());
        }

        @CrossOrigin(origins = "http://localhost:4200")
        @GetMapping(value = "/allActive")
        @ResponseBody
        public ResponseEntity<List<Advertisement>> getActiveAdvertisements(){
                return ResponseEntity.ok(advertisementService.findAllActiveAdvertisements());
        }

        @CrossOrigin(origins = "http://localhost:4200")
        @DeleteMapping ("/{id}")
        @ResponseBody
        public void deleteAdvertisement(@PathVariable Integer id){
               advertisementService.removeAdvertisement(id);
        }
}
