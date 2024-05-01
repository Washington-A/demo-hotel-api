package com.example.demohotelapi.service;

import com.example.demohotelapi.entity.Hotel;
import com.example.demohotelapi.entity.Quarto;
import com.example.demohotelapi.repository.HotelRepository;
import com.example.demohotelapi.repository.ReservaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    private final QuartoService quartoService;

    @Transactional(readOnly = true)
    public List<Hotel> buscarTodos() {
        List<Hotel> hoteis = hotelRepository.findAll();
        if (hoteis.isEmpty()) {
            Collections.emptyList();
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
            Collections.emptyList();
        }
        return hoteis;
    }

    @Transactional(readOnly = true)
    public List<Hotel> buscarPorDisponibilidade(LocalDate checkIn){

        List<Hotel> hoteis = hotelRepository.findAll();
        List<Hotel> hoteisDisponiveis = new ArrayList<>();
        List<Quarto> quartosDisponiveis = quartoService.buscarPorDisponibilidade(checkIn);

        if(quartosDisponiveis.isEmpty()){
            return Collections.emptyList();
        }

        for(Hotel hotel: hoteis){
            hotel.getQuartos().clear();
            for (Quarto quarto: quartosDisponiveis){
                if(quarto.getHotel_id() == hotel.getId()){
                    hotel.getQuartos().add(quarto);
                }
            }
            if(!hotel.getQuartos().isEmpty()){
                hoteisDisponiveis.add(hotel);
            }
        }
        return hoteisDisponiveis;
    }
}

