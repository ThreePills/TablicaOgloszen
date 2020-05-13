package com.piisw.backend.controller;

import java.util.List;

import com.piisw.backend.entity.Advertisement;
import com.piisw.backend.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping (value = "/advertisement")
public class AdvertisementController {

        private AdvertisementService advertisementService;

        public AdvertisementController(@Autowired AdvertisementService advertisementService) {
                this.advertisementService = advertisementService;
        }

        @PostMapping (value = "/addAdvertisement")
        @ResponseBody
        public ResponseEntity<Advertisement> addAdvertisement(@RequestBody Advertisement advertisement) {
                return ResponseEntity.ok(advertisementService.insertAdvertisement(advertisement));
        }

        @GetMapping (value = "/getAllAdvertisements")
        @ResponseBody
        public ResponseEntity<List<Advertisement>> getAdvertisements() {
                return ResponseEntity.ok(advertisementService.findAllAdvertisement());
        }
        @GetMapping(value = "/getAdvertisements")
        @ResponseBody
        public ResponseEntity<List<Advertisement>> getActiveAdvertisements(){
                return ResponseEntity.ok(advertisementService.findAllActiveAdvertisements());
        }
        @DeleteMapping ("/deleteAdvertisement/{id}")
        @ResponseBody
        public void deleteAdvertisement(@PathVariable Integer id){
               advertisementService.removeAdvertisement(id);
        }
}
