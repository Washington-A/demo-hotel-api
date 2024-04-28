package com.example.demohotelapi.service;

import com.example.demohotelapi.entity.Hotel;
import com.example.demohotelapi.repository.HotelRepository;
import com.example.demohotelapi.repository.ReservaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    private final ReservaRepository reservaRepository;

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

    @Transactional(readOnly = true)
    public List<Hotel> buscarPorDisponibilidade(LocalDate checkIn){
        List<Hotel> hoteis = hotelRepository.findAll();
        List<Hotel> hoteisDisponiveis = new ArrayList<>();

        for(Hotel hotel: hoteis){
            long quartosReservados = reservaRepository.getByHotelAndData(checkIn, hotel.getId()).size();
            if (hotel.getQtd_quartos() >= quartosReservados){
                hoteisDisponiveis.add(hotel);
            }
        }
        if (hoteis.isEmpty()) {
            throw new EntityNotFoundException("Nenhum hotel encontrado");
        }
        return hoteisDisponiveis;
    }
}

