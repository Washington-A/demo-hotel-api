package com.example.demohotelapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @GetMapping
    public ResponseEntity getAllHotels(){
        return ResponseEntity.ok("Deu ok.");
    }

}
