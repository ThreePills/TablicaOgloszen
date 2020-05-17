package com.piisw.backend.controller;

import java.util.List;

import com.piisw.backend.entity.Advertisement;
import com.piisw.backend.service.AdvertisementService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
        @GetMapping(value = "/allActive")
        @ResponseBody
        public ResponseEntity<List<Advertisement>> getActiveAdvertisements(){
                return ResponseEntity.ok(advertisementService.findAllActiveAdvertisements());
        }
        @DeleteMapping ("/{id}")
        @ResponseBody
        public void deleteAdvertisement(@PathVariable Integer id){
               advertisementService.removeAdvertisement(id);
        }

       //@PutMapping ("/{id}")
        //@ResponseBody
        //public ResponseEntity<Advertisement> updateAdvretisement(@PathVariable Long id, @RequestBody Advertisement advertisement){
        //        advertisementService.updateAdvertisement(id, advertisement);
        //}
}
