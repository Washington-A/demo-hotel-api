package com.example.demohotelapi.service;

import com.example.demohotelapi.entity.Quarto;
import com.example.demohotelapi.repository.QuartoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuartoService {
    private final QuartoRepository quartoRepository;
    @Transactional(readOnly = true)
    public List<Quarto> buscarPorDisponibilidade(LocalDate date) {
        List<Quarto> quartos = quartoRepository.findByAvailability(date);
        if (quartos.isEmpty()) {
            throw new EntityNotFoundException("Nenhum quarto encontrado");
        }
        return quartos;
    }
}
