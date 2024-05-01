package com.example.demohotelapi.web.controller;

import com.example.demohotelapi.entity.Quarto;
import com.example.demohotelapi.service.QuartoService;
import com.example.demohotelapi.web.dto.QuartoResponseDto;
import com.example.demohotelapi.web.dto.mapper.QuartoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/hoteis/quartos")
public class QuartoController {

    private final QuartoService quartoService;

    @GetMapping("/disponibilidade/{data}")
    public ResponseEntity<List<QuartoResponseDto>> getByAvailabilityAndHotel(@PathVariable LocalDate data) {
        List<Quarto> quartos = quartoService.buscarPorDisponibilidade(data);
        return ResponseEntity.ok(QuartoMapper.toListDto(quartos));
    }
}
