package com.example.demohotelapi.service;

import com.example.demohotelapi.entity.Hotel;
import com.example.demohotelapi.repository.HotelRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    @Transactional(readOnly = true)
    public List<Hotel> buscarTodos() {
        List<Hotel> hoteis = hotelRepository.findAll();
        if (hoteis.isEmpty()) {
            throw new EntityNotFoundException("Nenhum hotel encontrado");
        }
        return hoteis;
    }

    @Transactional(readOnly = true)
    public Hotel buscarPorId(int id) {
        return hotelRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Hotel id=%s não encontrado", id))
        );
    }

    @Transactional(readOnly = true)
    public List<Hotel> buscarPorLocalizacao(String local) {
        List<Hotel> hoteis = hotelRepository.findByLocation(local);
        if (hoteis.isEmpty()) {
            throw new EntityNotFoundException("Nenhum hotel encontrado");
        }
        return hoteis;
    }
}
