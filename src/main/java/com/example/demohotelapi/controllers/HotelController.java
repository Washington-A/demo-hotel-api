package com.example.demohotelapi.controllers;

import com.example.demohotelapi.repositories.HotelsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelsRepository hotelsRepository;

    @GetMapping
    public ResponseEntity getAllHotels() {
        try {
            var allHotels = hotelsRepository.findAll();
            return ResponseEntity.ok(allHotels);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao buscar hotéis.");
        }
    }
}
