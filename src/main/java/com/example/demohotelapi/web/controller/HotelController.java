package com.example.demohotelapi.web.controller;

import com.example.demohotelapi.entity.Hotel;
import com.example.demohotelapi.repository.HotelRepository;
import com.example.demohotelapi.service.HotelService;
import com.example.demohotelapi.web.dto.HotelResponseDto;
import com.example.demohotelapi.web.dto.mapper.HotelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/hoteis")
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<HotelResponseDto>> getAll() {
        List<Hotel> hoteis = hotelService.buscarTodos();
        return ResponseEntity.ok(HotelMapper.toListDto(hoteis));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponseDto> getById(@PathVariable String id) {
        Hotel hotel = hotelService.buscarPorId(id);
        return ResponseEntity.ok(HotelMapper.toDto(hotel));
    }
}